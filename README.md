# ideal-octo-disco

Simple Web Driver Example

    $ git clone https://github.com/masmangan/ideal-octo-disco.git
    $ cd ideal-octo-disco/
    $ mvn test

- Os testes implementados foram para a página https://web2.0calc.com/
- Há dois testes para a página de registro, um positivo e um negativo e um teste para a homepage.
- O projeto está estruturado com o padrão PageObjects.
- Há também um relatório de execução gerado com o Allure Framework, para gerar o relatório é necessário [instalar o Allure](https://docs.qameta.io/allure/#_installing_a_commandline).

Após a instalação basta rodar o comando:

    allure serve project/target/surefire-reports/

Após a execução do comando, o relatório é aberto no navegador padrão.
