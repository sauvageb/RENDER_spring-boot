# Déploiement d'un projet Spring Boot sur Render.com

### Informations

Nous allons suivre 2 grandes étapes afin de pouvoir déployer une API RestFul sur render.com

- Étape 1 : Génération d'un jar exécutable avec Maven
- Étape 2 : Sur Render.com, mettre en place un projet Web Service

#### Pré-requis :

- Dépôt git sur github ou gitlab
- JDK >= 8 et Maven >= 3
- Compte gratuit sur Render.com

### Etape 1 :

1) Dans le pom.xml, bien s'assurer que le :
   ```<packaging>jar</packaging>```


2) Lancer le lifecycle :
   ```mvn package```


3) Vous retrouverez le jar généré dans le dossier target :

![Jar dans le dossier target](https://raw.githubusercontent.com/sauvageb/RENDER_spring-boot/main/images/jar_generated.png)

4Vous pouvez exécuter le jar exécutable avec la commande :
```java -jar ./target/demo-spring-boot-0.0.1-SNAPSHOT.jar```

### Etape 2 :

1) Créez un fichier nommé Dockerfile à la racine du projet, contenant :

```dockerfile
   # définition de l’image de base pour créer l’image de votre application
   FROM eclipse-temurin:17-jdk-alpine
   # création d'un point de montage
   VOLUME /tmp
   # copie et renommage du fichier jar exécutable en app.jar
   COPY target/*.jar app.jar
   # définition de la commande à exécuter lors du démarrage de l'application
   ENTRYPOINT ["java","-jar","/app.jar"]
   # Configuration de l'application pour écouter sur le port 8080
   EXPOSE 8080
   ```

2) Commentez les lignes de votre .gitignore afin de versionner le dossier target :

```gitignore
   #target/
   #!.mvn/wrapper/maven-wrapper.jar
   #!**/src/main/**/target/
   #!**/src/test/**/target/
```

3) Envoyez votre code sur github ou gitlab


4) Créez un compte sur render.com et créez un nouveau projet Webservice (Dashboard -> Webservice)

![New Web service](https://raw.githubusercontent.com/sauvageb/RENDER_spring-boot/main/images/render_new_web_service.png)

5) Séléctionnez Build and deploy from a Git repository

![New Web service](https://raw.githubusercontent.com/sauvageb/RENDER_spring-boot/main/images/deploy_from_git.png)

6) Séléctionnez votre projet github et configurez les valeurs


7) Le projet est déployé !

