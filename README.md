# Dev Setup Installer

Instalador gráfico para ambientes de desenvolvimento em Windows e Linux, facilitando o download e instalação de ferramentas essenciais para desenvolvedores.

## Funcionalidades

- Interface moderna em JavaFX.
- Instalação de múltiplos softwares de desenvolvimento (Git, VS Code, Node.js, JDK, Python, Docker, IDEs, bancos de dados, utilitários e mais).
- Download automático dos instaladores no Windows.
- Execução de comandos de instalação no Linux (via terminal gráfico).
- Log detalhado do processo de instalação.
- Opção de selecionar todos os softwares de uma vez.

## Tecnologias Utilizadas

- Java 17+
- JavaFX 17
- Maven
- Bibliotecas: ControlsFX, FormsFX, ValidatorFX, Ikonli, BootstrapFX, TilesFX, FXGL

## Pré-requisitos

- Java 17 ou superior instalado.
- Maven 3.8+ instalado (ou use o wrapper `mvnw` incluso).
- Internet para baixar instaladores/comandos.

## Como Buildar

Clone o repositório e execute:

```sh
./mvnw clean package
```
ou, se preferir usar o Maven instalado no sistema:
```sh
mvn clean package
```

## Como Executar

Após o build, execute:

```sh
./mvnw javafx:run
```
ou
```sh
mvn javafx:run
```

## Estrutura do Projeto

- `src/main/java/org/setup/setupdev/DevApplication.java`: Classe principal da aplicação.
- `src/main/java/org/setup/setupdev/DevController.java`: Lógica da interface e instalação dos softwares.
- `src/main/resources/org/setup/setupdev/dev-view.fxml`: Layout da interface gráfica.
- `src/main/resources/style/style.css`: Estilos customizados da interface.
- `pom.xml`: Gerenciamento de dependências Maven.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LINCESE.md](LINCESE.md) para mais detalhes.