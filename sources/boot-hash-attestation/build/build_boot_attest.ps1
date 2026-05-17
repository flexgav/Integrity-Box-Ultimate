$ErrorActionPreference = "Stop"

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
$repo = Resolve-Path (Join-Path $root "..\..")
$src = Join-Path $root "src\com\flexgav\ibu\BootHashAttestation.java"
$outDir = Join-Path $repo "IntegrityBox-Ultimate-Clnt\webroot\common_scripts\BootHashAttestation"
$outJar = Join-Path $outDir "boot_attest.jar"

$sdk = $env:ANDROID_HOME
if ([string]::IsNullOrWhiteSpace($sdk)) {
    $sdk = $env:ANDROID_SDK_ROOT
}
if ([string]::IsNullOrWhiteSpace($sdk)) {
    $sdk = Join-Path $env:LOCALAPPDATA "Android\Sdk"
}

$androidJar = Get-ChildItem -Path (Join-Path $sdk "platforms") -Filter "android.jar" -Recurse |
Sort-Object FullName -Descending |
Select-Object -First 1
if (-not $androidJar) {
    throw "android.jar was not found in Android SDK: $sdk"
}

$d8 = Get-ChildItem -Path (Join-Path $sdk "build-tools") -Filter "d8.bat" -Recurse |
Sort-Object FullName -Descending |
Select-Object -First 1
if (-not $d8) {
    throw "d8.bat was not found in Android SDK: $sdk"
}

$stamp = Get-Date -Format "yyyyMMddHHmmss"
$build = Join-Path "D:\tmp" "ibu_bootattest_build_$stamp"
$classes = Join-Path $build "classes"
$dex = Join-Path $build "dex"
$zip = Join-Path $build "boot_attest.zip"

New-Item -ItemType Directory -Force -Path $classes | Out-Null
New-Item -ItemType Directory -Force -Path $dex | Out-Null
New-Item -ItemType Directory -Force -Path $outDir | Out-Null

javac -source 8 -target 8 -Xlint:-options -bootclasspath $androidJar.FullName -d $classes $src
if ($LASTEXITCODE -ne 0) {
    throw "javac failed with exit code $LASTEXITCODE"
}

$classFiles = Get-ChildItem -Path $classes -Recurse -Filter "*.class" | ForEach-Object { $_.FullName }
if (-not $classFiles -or $classFiles.Count -eq 0) {
    throw "No .class files were produced by javac"
}

& $d8.FullName --min-api 26 --output $dex @classFiles
if ($LASTEXITCODE -ne 0) {
    throw "d8 failed with exit code $LASTEXITCODE"
}

Compress-Archive -Path (Join-Path $dex "classes.dex") -DestinationPath $zip -Force
Move-Item -LiteralPath $zip -Destination $outJar -Force

$result = Get-Item -LiteralPath $outJar
Write-Host "Built $($result.FullName) ($($result.Length) bytes)"
