// First-party source (IntegrityBox, PlayIntegrityFork lineage).
// Shared reflective writer for android.os.Build / Build.VERSION fields (S2),
// with a resolve cache (P2) so repeated spoofing does not re-run getDeclaredField.
// Unifies the previously duplicated setField (EntryPoint) and setBuildField /
// spoofSdkInt (EntryPointVending) logic. Internal helper — not part of the JNI
// contract. Per-process state (each target process loads its own dex).
package es.chiteroman.playintegrityfix;

import android.os.Build;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class BuildFields {
    private BuildFields() {}

    // Positive cache: resolved + accessible Build/Build.VERSION fields by name.
    private static final Map<String, Field> CACHE = new HashMap<>();

    private static Field lookup(Class<?> owner, String name) {
        try { return owner.getDeclaredField(name); }
        catch (NoSuchFieldException e) { return null; }
    }

    // Resolve a field by name in Build, then Build.VERSION. Cached + made
    // accessible once. Returns null if neither class declares it.
    static Field resolve(String name) {
        Field f = CACHE.get(name);
        if (f != null) return f;
        f = lookup(Build.class, name);
        if (f == null) f = lookup(Build.VERSION.class, name);
        if (f != null) {
            f.setAccessible(true);
            CACHE.put(name, f);
        }
        return f;
    }

    // Set a Build/Build.VERSION field from a string value, coercing to the
    // field's type. No-op (with verbose logging) if the value is empty, the
    // field is unknown, or the value is already current.
    static void set(String name, String value, Logger log) {
        if (value == null || value.isEmpty()) {
            if (log.level > 1) log.d(name + " empty skip");
            return;
        }
        Field field = resolve(name);
        if (field == null) {
            if (log.level > 1) log.d(name + " field unknown");
            return;
        }
        try {
            String oldValue = String.valueOf(field.get(null));
            if (value.equals(oldValue)) {
                if (log.level > 2) log.d(name + " " + value + " unchanged");
                return;
            }
            Class<?> type = field.getType();
            Object newValue;
            if (type == String.class) newValue = value;
            else if (type == int.class || type == Integer.class) newValue = Integer.parseInt(value);
            else if (type == long.class || type == Long.class) newValue = Long.parseLong(value);
            else if (type == boolean.class || type == Boolean.class) newValue = Boolean.parseBoolean(value);
            else {
                log.e(name + " type " + type.getName() + " unsupported");
                return;
            }
            field.set(null, newValue);
            log.d(name + " " + oldValue + " -> " + value);
        } catch (NumberFormatException e) {
            log.e(name + " parse " + value + ": " + e.getMessage());
        } catch (IllegalAccessException e) {
            log.e(name + " set: " + e.getMessage());
        }
    }
}
