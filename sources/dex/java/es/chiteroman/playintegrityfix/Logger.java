// First-party source (IntegrityBox, PlayIntegrityFork lineage).
// Shared logging shim (S1): one instance per tag, gated by a verbosity level.
// Replaces the duplicated static LOG/LOGI/LOGE scaffolding that previously
// lived in both EntryPoint and EntryPointVending. Internal helper — not part of
// the JNI contract, free for R8 to inline/obfuscate.
package es.chiteroman.playintegrityfix;

import android.util.Log;

final class Logger {
    final String tag;
    int level;

    Logger(String tag) { this.tag = tag; }

    void d(String msg) { if (level > 0) Log.d(tag, msg); }
    void i(String msg) { if (level > 0) Log.i(tag, msg); }
    void e(String msg) { if (level > 0) Log.e(tag, msg); }
}
