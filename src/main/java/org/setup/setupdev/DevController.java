package org.setup.setupdev;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class DevController {

    @FXML
    private CheckBox selectAllCheckBox;

    @FXML
    private CheckBox gitCheckBox, vscodeCheckBox, nodeCheckBox, javaCheckBox, pythonCheckBox,
            httpieCheckBox, eclipseCheckBox, springToolsCheckBox, androidStudioCheckBox,
            pycharmCheckBox, notepadppCheckBox, notionCheckBox, dbeaverCheckBox, postmanCheckBox,
            dockerDesktopCheckBox, postgresqlCheckBox, githubDesktopCheckBox, mongoCompassCheckBox,
            insomniaCheckBox, figmaDesktopCheckBox, sevenZipCheckBox, cmderCheckBox;

    @FXML
    private TextArea logTextArea;

    private final Map<String, String> softwareWindowsLinks = new HashMap<>();
    private final Map<String, String> softwareLinuxCommands = new HashMap<>();
    private final Map<CheckBox, String> softwareMap = new HashMap<>();

    private final boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");

    public void initialize() {
        // Windows installers
        softwareWindowsLinks.put("Git", "https://github.com/git-for-windows/git/releases/download/v2.45.1.windows.1/Git-2.45.1-64-bit.exe");
        softwareWindowsLinks.put("Visual Studio Code", "https://update.code.visualstudio.com/latest/win32-x64-user/stable");
        softwareWindowsLinks.put("Node.js", "https://nodejs.org/dist/v20.11.0/node-v20.11.0-x64.msi");
        softwareWindowsLinks.put("Java JDK", "https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.exe");
        softwareWindowsLinks.put("Python", "https://www.python.org/ftp/python/3.12.3/python-3.12.3-amd64.exe");
        softwareWindowsLinks.put("HTTPie", "https://github.com/httpie/httpie/releases/download/3.2.2/httpie-3.2.2-x64.exe");
        softwareWindowsLinks.put("Eclipse", "https://ftp.fau.de/eclipse/technology/epp/downloads/release/2024-03/R/eclipse-inst-jre-win64.exe");
        softwareWindowsLinks.put("Spring Tools Suite", "https://download.springsource.com/release/STS4/4.21.1.RELEASE/dist/e4.29/windows/spring-tool-suite-4-4.21.1.RELEASE-e4.29.0-win32.win32.x86_64.exe");
        softwareWindowsLinks.put("Android Studio", "https://redirector.gvt1.com/edgedl/android/studio/install/2024.1.2.0/android-studio-2024.1.2.0-windows.exe");
        softwareWindowsLinks.put("PyCharm", "https://download.jetbrains.com/python/pycharm-community-2024.1.1.exe");
        softwareWindowsLinks.put("Notepad++", "https://github.com/notepad-plus-plus/notepad-plus-plus/releases/download/v8.6.5/npp.8.6.5.Installer.x64.exe");
        softwareWindowsLinks.put("Notion", "https://desktop-release.notion-static.com/Notion%20Setup%202.3.3.exe");
        softwareWindowsLinks.put("DBeaver", "https://dbeaver.io/files/dbeaver-ce-latest-x86_64-setup.exe");
        softwareWindowsLinks.put("Postman", "https://dl.pstmn.io/download/latest/win64");
        softwareWindowsLinks.put("Docker Desktop", "https://desktop.docker.com/win/stable/Docker%20Desktop%20Installer.exe");
        softwareWindowsLinks.put("PostgreSQL", "https://get.enterprisedb.com/postgresql/postgresql-15.4-1-windows-x64.exe");
        softwareWindowsLinks.put("GitHub Desktop", "https://central.github.com/deployments/desktop/desktop/latest/win32");
        softwareWindowsLinks.put("MongoDB Compass", "https://downloads.mongodb.com/compass/mongodb-compass-1.39.2-win64.exe");
        softwareWindowsLinks.put("Insomnia", "https://updates.insomnia.rest/downloads/win32/Insomnia.Insomnia-2024.1.0.exe");
        softwareWindowsLinks.put("Figma Desktop", "https://desktop.figma.com/win/FigmaSetup.exe");
        softwareWindowsLinks.put("7-Zip", "https://www.7-zip.org/a/7z2301-x64.exe");
        softwareWindowsLinks.put("Cmder", "https://github.com/cmderdev/cmder/releases/download/v1.3.24/cmder.zip");

        // Linux installation commands (apt, snap, etc)
        softwareLinuxCommands.put("Git", "sudo apt update && sudo apt install git -y");
        softwareLinuxCommands.put("Visual Studio Code", "sudo snap install --classic code");
        softwareLinuxCommands.put("Node.js", "curl -fsSL https://deb.nodesource.com/setup_20.x | sudo -E bash - && sudo apt install -y nodejs");
        softwareLinuxCommands.put("Java JDK", "sudo apt update && sudo apt install openjdk-17-jdk -y");
        softwareLinuxCommands.put("Python", "sudo apt update && sudo apt install python3 python3-pip -y");
        softwareLinuxCommands.put("HTTPie", "sudo apt update && sudo apt install httpie -y");
        softwareLinuxCommands.put("Eclipse", "sudo snap install --classic eclipse");
        softwareLinuxCommands.put("Spring Tools Suite", "Não disponível via repositório padrão, baixe do site oficial https://spring.io/tools");
        softwareLinuxCommands.put("Android Studio", "sudo snap install android-studio --classic");
        softwareLinuxCommands.put("PyCharm", "sudo snap install pycharm-community --classic");
        softwareLinuxCommands.put("Notepad++", "sudo snap install notepad-plus-plus");
        softwareLinuxCommands.put("Notion", "Não há versão oficial Linux, utilize versões alternativas como notion-app ou via web");
        softwareLinuxCommands.put("DBeaver", "sudo snap install dbeaver-ce");
        softwareLinuxCommands.put("Postman", "sudo snap install postman");
        softwareLinuxCommands.put("Docker Desktop", "sudo apt install docker.io && sudo systemctl start docker && sudo systemctl enable docker");
        softwareLinuxCommands.put("PostgreSQL", "sudo apt update && sudo apt install postgresql postgresql-contrib -y");
        softwareLinuxCommands.put("GitHub Desktop", "Não há versão oficial Linux, use Git via terminal ou clientes alternativos");
        softwareLinuxCommands.put("MongoDB Compass", "Não há versão oficial Linux, use MongoDB via terminal ou clientes alternativos");
        softwareLinuxCommands.put("Insomnia", "sudo snap install insomnia");
        softwareLinuxCommands.put("Figma Desktop", "Não há versão oficial Linux, use versão web");
        softwareLinuxCommands.put("7-Zip", "sudo apt install p7zip-full p7zip-rar -y");
        softwareLinuxCommands.put("Cmder", "Não disponível para Linux, utilize o terminal padrão ou ferramentas como Tilix, Terminator");

        // Map checkboxes to software names
        softwareMap.put(gitCheckBox, "Git");
        softwareMap.put(vscodeCheckBox, "Visual Studio Code");
        softwareMap.put(nodeCheckBox, "Node.js");
        softwareMap.put(javaCheckBox, "Java JDK");
        softwareMap.put(pythonCheckBox, "Python");
        softwareMap.put(httpieCheckBox, "HTTPie");
        softwareMap.put(eclipseCheckBox, "Eclipse");
        softwareMap.put(springToolsCheckBox, "Spring Tools Suite");
        softwareMap.put(androidStudioCheckBox, "Android Studio");
        softwareMap.put(pycharmCheckBox, "PyCharm");
        softwareMap.put(notepadppCheckBox, "Notepad++");
        softwareMap.put(notionCheckBox, "Notion");
        softwareMap.put(dbeaverCheckBox, "DBeaver");
        softwareMap.put(postmanCheckBox, "Postman");
        softwareMap.put(dockerDesktopCheckBox, "Docker Desktop");
        softwareMap.put(postgresqlCheckBox, "PostgreSQL");
        softwareMap.put(githubDesktopCheckBox, "GitHub Desktop");
        softwareMap.put(mongoCompassCheckBox, "MongoDB Compass");
        softwareMap.put(insomniaCheckBox, "Insomnia");
        softwareMap.put(figmaDesktopCheckBox, "Figma Desktop");
        softwareMap.put(sevenZipCheckBox, "7-Zip");
        softwareMap.put(cmderCheckBox, "Cmder");
    }

    @FXML
    protected void onSelectAll() {
        boolean selected = selectAllCheckBox.isSelected();
        softwareMap.keySet().forEach(cb -> cb.setSelected(selected));
    }

    @FXML
    protected void onInstallClick() {
        log("Iniciando processo de instalação...");

        if (isWindows) {
            DirectoryChooser chooser = new DirectoryChooser();
            chooser.setTitle("Selecione a pasta para salvar os instaladores");
            File selectedDir = chooser.showDialog(null);

            if (selectedDir == null) {
                log("Instalação cancelada. Nenhuma pasta selecionada.");
                return;
            }

            new Thread(() -> {
                try {
                    for (Map.Entry<CheckBox, String> entry : softwareMap.entrySet()) {
                        if (entry.getKey().isSelected()) {
                            installSoftwareWindows(softwareWindowsLinks.get(entry.getValue()), entry.getValue(), selectedDir);
                        }
                    }
                    log("Processo concluído.");
                } catch (Exception e) {
                    log("Erro durante a instalação: " + e.getMessage());
                    e.printStackTrace();
                }
            }).start();

        } else {
            // Linux - tentar abrir terminal gráfico e rodar comandos
            new Thread(() -> {
                boolean terminalFound = false;
                String[] terminalsToTry = {"gnome-terminal", "konsole", "xfce4-terminal", "xterm"};

                StringBuilder commandsToRun = new StringBuilder();
                for (Map.Entry<CheckBox, String> entry : softwareMap.entrySet()) {
                    if (entry.getKey().isSelected()) {
                        String cmd = softwareLinuxCommands.get(entry.getValue());
                        if (cmd == null) {
                            log("Comando de instalação para " + entry.getValue() + " não disponível.");
                        } else {
                            commandsToRun.append(cmd).append(" && ");
                        }
                    }
                }

                if (commandsToRun.length() == 0) {
                    log("Nenhum software selecionado para instalação.");
                    return;
                }

                // Remove o último " && "
                commandsToRun.setLength(commandsToRun.length() - 4);

                for (String terminal : terminalsToTry) {
                    try {
                        // Testa se o terminal existe executando "which terminal"
                        Process whichProc = new ProcessBuilder("which", terminal).start();
                        int exitCode = whichProc.waitFor();
                        if (exitCode == 0) {
                            // Terminal encontrado, executa comando dentro dele
                            log("Abrindo terminal '" + terminal + "' para executar comandos...");
                            String[] cmdArray;
                            if (terminal.equals("gnome-terminal")) {
                                cmdArray = new String[] {
                                        terminal,
                                        "--",
                                        "bash", "-c",
                                        commandsToRun.toString() + "; echo 'Pressione ENTER para fechar...'; read"
                                };
                            } else if (terminal.equals("konsole")) {
                                cmdArray = new String[] {
                                        terminal,
                                        "-e",
                                        "bash", "-c",
                                        commandsToRun.toString() + "; echo 'Pressione ENTER para fechar...'; read"
                                };
                            } else if (terminal.equals("xfce4-terminal")) {
                                cmdArray = new String[] {
                                        terminal,
                                        "-e",
                                        "bash", "-c",
                                        commandsToRun.toString() + "; echo 'Pressione ENTER para fechar...'; read"
                                };
                            } else if (terminal.equals("xterm")) {
                                cmdArray = new String[] {
                                        terminal,
                                        "-hold",
                                        "-e",
                                        "bash", "-c",
                                        commandsToRun.toString()
                                };
                            } else {
                                // fallback genérico, roda no bash
                                cmdArray = new String[] {
                                        terminal,
                                        "-e",
                                        "bash", "-c",
                                        commandsToRun.toString()
                                };
                            }
                            new ProcessBuilder(cmdArray).start();
                            terminalFound = true;
                            break;
                        }
                    } catch (Exception e) {
                        // não encontrou esse terminal, tenta próximo
                    }
                }

                if (!terminalFound) {
                    log("Não foi possível encontrar terminal gráfico para rodar comandos automaticamente.");
                    log("Por favor, execute os seguintes comandos no terminal manualmente:");
                    for (Map.Entry<CheckBox, String> entry : softwareMap.entrySet()) {
                        if (entry.getKey().isSelected()) {
                            String cmd = softwareLinuxCommands.get(entry.getValue());
                            if (cmd != null) {
                                log(cmd);
                            } else {
                                log("Comando de instalação para " + entry.getValue() + " não disponível.");
                            }
                        }
                    }
                }
            }).start();
        }
    }

    private void installSoftwareWindows(String url, String name, File directory) throws IOException {
        if (url == null) {
            log("Link de download não encontrado para " + name);
            return;
        }

        if (!isValidURL(url)) {
            log("URL inválida ou inacessível para " + name);
            return;
        }

        log("Baixando: " + name + "...");
        String fileName = getFileNameFromURL(url);
        File destination = new File(directory, fileName);

        try (InputStream in = new URL(url).openStream()) {
            Files.copy(in, destination.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            log(name + " baixado com sucesso.");

            log("Executando instalador de " + name + "...");
            Process process = new ProcessBuilder(destination.getAbsolutePath()).start();
            process.waitFor();
            log(name + " instalado com sucesso.");
        } catch (Exception e) {
            log("Erro ao instalar " + name + ": " + e.getMessage());
        }
    }

    private boolean isValidURL(String urlStr) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("HEAD");
            conn.setConnectTimeout(5000);
            conn.connect();
            return conn.getResponseCode() == 200;
        } catch (IOException e) {
            return false;
        }
    }

    private String getFileNameFromURL(String urlStr) {
        String[] parts = urlStr.split("/");
        String fileName = parts[parts.length - 1];
        return fileName.contains("?") ? fileName.split("\\?")[0] : fileName;
    }

    private void log(String text) {
        logTextArea.appendText(text + "\n");
    }
}
