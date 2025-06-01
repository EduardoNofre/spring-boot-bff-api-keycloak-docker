
<h1 align="center"> 
  Vamos estudar  
</h1>

<p align="center">
  <img src="https://github.com/EduardoNofre/spring-boot-bff-api-keycloak-docker/blob/main/Estudo%20de%20arquitetura.png"/>  
</p>

<h1 align="center">
   O que será usado aqui neste estudo.
</h1>

01 - Ide eclipse sts.<br>
02 - Java 17.<br>
03 - banco de dados postgres-sql.<br>
04 - lombok.<br>
05 - Spring boot 3.4.5.<br>
06 - Docker <br>
07 - Docker Compose.<br>
08 - Keycloak.<br>
09 - OpenFeing.<br>
10 - Repositorio config server. 👉 [Link do repositorio config serve](https://github.com/EduardoNofre/config-server-portal-noticias)<br>
10 - config server. 

<h1 align="center">
   Modelo da arquiteura que iremos construir
</h1>
<p align="center">
  <img src="https://github.com/EduardoNofre/spring-boot-bff-api-keycloak-docker/blob/main/desenhoArq.png"/>  
</p>

<h1 align="center">
   Alguns pontos relevantes sobre BFF.
</h1>

## O que é BFF.<br>
  BFF (Backend for Frontend) é um padrão de arquitetura de sistemas onde você cria um backend específico para cada tipo de frontend (como web, mobile, smartwatch, etc.)<br>

## Para que serve o BFF?
  O objetivo principal do BFF é adaptar as respostas do backend para as necessidades específicas de cada frontend, melhorando performance, simplificando a lógica no cliente e permitindo maior autonomia entre times de desenvolvimento.<br>

## Vantagens do BFF:
   - Customização por frontend
   - Desacoplamento entre frontend e backend
   - Melhoria de performance (dados sob medida, menos requisições)
   - Facilidade de manutenção e evolução
   - segurança sua api não fica exposta.

## Imagine o seguinte cenário.<br>
Você tem um restaurante (que é seu sistema).<br>
  Um cliente da mesa **web** quer uma refeição completa com entrada, prato principal e sobremesa.<br>
  Um cliente da mesa **mobile** só quer um lanche rápido.<br>
  Se só existisse um **"garçom"** para todos, ele traria a mesma comida para todos — o que nem sempre faz sentido.<br>

Com BFF, você cria um **“garçom”** especial para cada tipo de cliente:<br>
  Um BFF para o **site web**, que traz tudo completo.<br>
  Um BFF para o **app mobile**, que traz só o necessário.<br>

## Por que isso é bom?
   - Cada cliente recebe só o que precisa.
   - Tudo fica mais rápido e organizado.
   - O time que cuida do app pode trabalhar separado do time que cuida do site.

<h1 align="center">
   Alguns pontos relevantes sobre API.
</h1>

## O que é uma API?
API significa Interface de Programação de Aplicações (em inglês, Application Programming Interface).<br>
API é um meio de comunicação entre programas.<br>

## Veja por esse lado.
Pensa nela como um cardápio de restaurante:<br>
O cardápio mostra o que você pode pedir (mas você não vê como a comida é feita).<br>
Você escolhe o que quer e faz o pedido.<br>
A cozinha prepara e entrega.<br>

<h1 align="center">
   dokcer.
</h1>

## O que é dokcer?
Docker é como um container de navio, mas para programas.<br>
É um navio, cada **container** pode ter coisas diferentes: <br>
eletrônicos, comida, roupas.<br>
No Docker, cada "container" carrega um programa completo com tudo o que ele precisa para funcionar: código, configurações, bibliotecas...<br>

## O docker venho para resolver o famoso "na minha maquina funciona".<br>
Você tem um site que funciona bem no seu computador.<br>
Aí vai rodar em outro servidor e… 💥 dá erro.<br>
Com Docker, você coloca esse site dentro de um "container".<br>
Agora, funciona igual em qualquer computador, servidor, ou nuvem.<br>

<h1 align="center">
   docker compose
</h1>

## O que é docker compose?
Docker Compose é uma ferramenta que junta vários **containers Docker** e faz eles **trabalharem juntos**.<br>
Agora temos uma frota de navio e uma infinidade **containers Docker** trabalhando juntos <br>

## Um exemplo mais pratico.
Imagina que você tem um site que precisa de:
Um servidor web (por exemplo, Nginx)
Um banco de dados (por exemplo, MySQL)
Um serviço de login
Cada um roda em um **container Docker** separado.
Em vez de ligar tudo na mão, um por um...
👉 Você usa o **Docker Compose** para ligar todos de uma vez só com um arquivo de configuração.
Esse arquivo se chama **docker-compose.yml** e diz:
Quais containers usar
Como eles se conectam
Quais portas abrir
Que volumes usar (armazenamento)

## Resumo!
Docker Compose é como um **maestro** que comanda vários **containers Docker** ao mesmo tempo

<h1 align="center">
   Keycloak
</h1>

## O que é Keycloak?
Keycloak é uma ferramenta que cuida de login, logout e segurança de acesso para sistemas e aplicativos.<br>

## uma visão simples do Keycloak.
É como um porteiro digital..<br>
Ele verifica quem você é, se você pode entrar, e o que você pode fazer dentro do sistema..<br>

## Como podemos utilizar o keycloak?
Fazer login com usuário e senha<br>
Usar login social (Google, Facebook, etc)<br>
Criar perfis de acesso (admin, usuário, etc)<br>
Proteger **APIs** e **aplicativos web/mobile**<br>
Ter login único (SSO) entre vários sistemas<br>

<h1 align="center">
   O que iremos desenvolver aqui para aprendizado.
</h1>

  1 - Uma Api de **"noticias diaria"**.<br>
  2 - Dois BFF **BFF-mobile** e **BFF-Web**<br>
  3 - criar **script de banco** tabelas.<br>
  4 - Gerar imagens dos BFF e da API com **docker** e subir para docker hub.<br>
  5 - Executar o keycloack com docker-compose.<br>
  6 - Criar no **keycloack** os usuarios sistema-BFF-mobile,usuarios sistema-BFF-web, sistema-API, usuario-admin, usuario-gerencial e usuario-padrão.<br>
      6.1 - Usuario sistema-BFF-mobile: Usuario sistema que permite que ele acesse a api sistmas.<br>
      6.2 - Usuario sistema-BFF-web:  Usuario sistema que permite que ele acesse a api sistmas.<br>
      6.3 - Usuario usuario-admin: Usuario administrador acesso total a aplicação.<br>
      6.4 - Usuario usuario-gerencial: Usuario gerencial acesso somente a area gerencial.<br>
      6.5 - Usuario usuario-padrão: Usuario padrão acesso somente area de atuação.<br>
      6.6 - Usuario sistema-BFF-mobile-swagger: Usuario com acesso a visualizar swagger e executar somente o mobile serviços.<br>
      6.7 - Usuario sistema-BFF-web-swagger: Usuario com acesso a visualizar swagger e executar somente o web web serviços.<br>
        
<h1 align="center">
  O desenvolvimento da APi sistemas.
</h1>        

Teremos os endpoints utilizando os seguintes verbos.<br>
    **GET** - Para consultas.<br>
    **POST** - Inserção de dados.<br>
    **DELETE** - Deletar registro.<br>
    **PUT** - Atualizar dados.<br>
    
    
    
