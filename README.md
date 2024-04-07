# Projeto JSF com PrimeFaces
![GitHub top language](https://img.shields.io/github/languages/top/Henrique2305/primefaces-new-version-deploy)

## Descriçao

É um projeto simples de CRUD com Java e PrimeFaces.

## ✔️ Tecnologias utilizadas

- ``Java 8``
- ``PrimeFaces``
- ``Dockerfile``
- ``PostgreSQL``

## Modo de uso

Usei a IDE Intellij.

Para rodar o projeto, use um servidor como o Tomcat. Eu usei a versão 9.0.60.

No arquivo hibernate.cfg.xml, altere o user, password e o nome do banco de dados (opcinal).

No IntelliJ, edite as configurações de run/debug e, adicione o tomcat server local. Na área de deployment, adicione o artifact do jsf-demo:war.

Rode o projeto. A primeira página que abrirá, é o index.xhtml. Essa é a página da listagem dos usuários.

