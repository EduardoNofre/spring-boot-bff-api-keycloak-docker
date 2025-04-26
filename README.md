
<h1 align="center"> 
  Vamos estudar  
</h1>

<p align="center">
  <img src="https://github.com/EduardoNofre/spring-boot-bff-api-keycloak-docker/blob/main/Estudo%20de%20arquitetura.png"/>  
</p>

<h1 align="center">
   O que será usado aqui neste estudo.
</h1>

1 - Ide eclipse sts.<br>
2 - Java 17.<br>
3 - banco de dados postgres-sql.<br>
4 - lombok.<br>
5 - Spring boot 3.4.5.<br>
6 - Docker Compose.<br>
7 - Keycloak.<br>

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
  Se só existisse um garçom para todos, ele traria a mesma comida para todos — o que nem sempre faz sentido.<br>

Com BFF, você cria um **“garçom”** especial para cada tipo de cliente:<br>
  Um BFF para o **site web**, que traz tudo completo.<br>
  Um BFF para o **app mobile**, que traz só o necessário.<br>

  
