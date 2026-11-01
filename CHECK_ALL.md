Compile check from package root (PowerShell):

```powershell
Get-ChildItem -Recurse -Filter *.java | ForEach-Object {
  Push-Location $_.DirectoryName
  javac $_.Name
  Pop-Location
}
```

If compilation succeeds, each program is ready to run with `java ClassName` from its own folder.
