# Snort IDS Demonstration Guide

The CCS record's Experiment 10 uses Snort, not Java. The Java `SimpleIDS` program is included as a runnable classroom simulation. To demonstrate actual network intrusion detection, use a supported Snort release and follow its official installation documentation.

The original record describes these tasks:
1. Install Snort and its required packet-capture driver for your operating system.
2. Obtain the appropriate Snort rules.
3. Configure the protected network (`HOME_NET`) and rule paths in the Snort configuration.
4. Identify the correct network interface.
5. Validate the configuration before starting packet inspection.
6. Run Snort in IDS/alert mode and inspect generated alerts.

The commands in the historical record use an older Windows Snort layout and may not match current Snort versions. Do not copy old DLL paths or configuration directives blindly. Use the official documentation for your installed Snort version.

Only monitor systems and networks that you own or have permission to test. For a safe lab, use two virtual machines on an isolated host-only network.
