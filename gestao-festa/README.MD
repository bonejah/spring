Example an application using SpringBoot

Technologies
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Thymeleaf
- Mysql/Postgres

- Heroku
 - Install Heroku Cli (https://devcenter.heroku.com/articles/heroku-cli)
  - Commands on mac: brew install heroku/brew/heroku 
  - heroku login
  - heroku create bonejah-gestao-festa
   - https://bonejah-gestao-festa.herokuapp.com/ | https://git.heroku.com/bonejah-gestao-festa.git
  - heroku git:remote -a bonejah-gestao-festa
  - heroku addons:create heroku-postgresql:hobby-dev
  - heroku logs --tail
  - heroku ps --app bonejah-gestao-festa
To start the application Run Application.java: http://localhost:8080/convidados
