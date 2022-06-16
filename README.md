# Lib Banner Spring boot

***Sobre a lib***

Dependëncia dedicada a exibir um banner personalizado subistituindo o banner original de aplicações SpringBoot

A lib oferece visualição de um banner com amostra de sua escolha, assim como também mostra informações basicas sobre o projeto durante sua inicialização.

- PORTA DO PROJETO
- NOME DO PROJETO
- PERFIL ATIVO 
- NOME DA ORGANIZACAO
- VERSÃO DO SPRINGBOOT 
- VERSÃO DO PROJETO 
- DESCRICAO DO PROJETO

***As opções acimas podem ser facilmente personalizadas, assim como também é possível contribuir adicionando novas opções***.
***Dependência***

Link: [Projeto no Github](https://github.com/nuLL-cmd/banner-spring-custom)<br>

***Utilizição***

Para que a depência exiba os dados de acordo com o programado, é necessário que algumas informçãos sobre a aplicação estejam presentes no arquivo ***properties*** default do projeto.

Excemplo usando .yaml:

>```YAML
>app:
>  contextPath: '@project.artifactId@'
>  version: '@project.version@'
>  description: '@project.description@'
>  organization: '@project.organization.name@'
>  name: '@project.name@'
>```

Exemplo usando .properties:

>```PROPERTIES
>app.version=@project.version@
>app.name=@project.name@
>app.description=@projectt.description@
>app.organization=@project.organization.name@    
>app.context-path=@project.artifactId@
>```

Após realizar tais configuraçõess, basta setar o banner no metodo main da aplicação que a configuração default será aplicada:

>```JAVA
>@SpringBootApplication
>public class ChickenApplication {
>
>    public static void main(String[] args) {
>        SpringApplication application = new SpringApplication(ChickenApplication.lass);
>        application.setBanner(new CustomBanner());	
>        application.run(args);
>    }
>
>}
>```

Você pode também usar seu próprio banner personalizado usando o meetodo <font color="red">setCustomBanner(String[])</font>

>```JAVA
>@SpringBootApplication
>public class ChickenApplication {
>
>    private static final String[] BANNER = {
>        ",-----.   ,--." ,                              
>        "|  |) /_  |  ,---.  ,--.,--. ,--.,--. ,--.,--.", 
>        "|  .-.  | |  .-.  | |  ||  | |  ||  | |  ||  |", 
>        "`------'  `--' `--'  `----'   `----'   `----' \n"
>    };
>
>    public static void main(String[] args) {
>        CustomBanner customBanner = new CustomBanner();
>        customBanner.setCustomBanner(BANNER);
>        
>        SpringApplication application = new SpringApplication(ChickenApplication.class);
>        application.setBanner(customBanner);
>        application.run(args);
>    }
>
>
>}
>```
# Lib Banner Spring boot

***Sobre a lib***

Dependëncia dedicada a exibir um banner personalizado subistituindo o banner original de aplicações SpringBoot

A lib oferece visualição de um banner com amostra de sua escolha, assim como também mostra informações basicas sobre o projeto durante sua inicialização.

- PORTA DO PROJETO
- NOME DO PROJETO
- PERFIL ATIVO 
- NOME DA ORGANIZACAO
- VERSÃO DO SPRINGBOOT 
- VERSÃO DO PROJETO 
- DESCRICAO DO PROJETO

***As opções acimas podem ser facilmente personalizadas, assim como também é possível contribuir adicionando novas opções***.
***Dependência***

Link: [Projeto no Github](https://github.com/nuLL-cmd/banner-spring-custom)<br>

***Utilizição***

Para que a depência exiba os dados de acordo com o programado, é necessário que algumas informçãos sobre a aplicação estejam presentes no arquivo ***properties*** default do projeto.

Excemplo usando .yaml:

>```YAML
>app:
>  contextPath: '@project.artifactId@'
>  version: '@project.version@'
>  description: '@project.description@'
>  organization: '@project.organization.name@'
>  name: '@project.name@'
>```

Exemplo usando .properties:

>```PROPERTIES
>app.version=@project.version@
>app.name=@project.name@
>app.description=@projectt.description@
>app.organization=@project.organization.name@    
>app.context-path=@project.artifactId@
>```

Após realizar tais configuraçõess, basta setar o banner no metodo main da aplicação que a configuração default será aplicada:

>```JAVA
>@SpringBootApplication
>public class ChickenApplication {
>
>    public static void main(String[] args) {
>        SpringApplication application = new SpringApplication(ChickenApplication.lass);
>        application.setBanner(new CustomBanner());	
>        application.run(args);
>    }
>
>}
>```

Você pode também usar seu próprio banner personalizado usando o meetodo <font color="orange">setCustomBanner()</font>

>```JAVA
>@SpringBootApplication
>public class ChickenApplication {
>
>    private static final String[] BANNER = {
>        ",-----.   ,--." ,                              
>        "|  |) /_  |  ,---.  ,--.,--. ,--.,--. ,--.,--.", 
>        "|  .-.  | |  .-.  | |  ||  | |  ||  | |  ||  |", 
>        "`------'  `--' `--'  `----'   `----'   `----' \n"
>    };
>
>    public static void main(String[] args) {
>        CustomBanner customBanner = new CustomBanner();
>        customBanner.setCustomBanner(BANNER);
>        
>        SpringApplication application = new SpringApplication(ChickenApplication.class);
>        application.setBanner(customBanner);
>        application.run(args);
>    }
>
>
>}
>```

O resultado obtido no console do catalina será algo como a saida abaixo.

```LOG
,-----.   ,--.
|  |) /_  |  ,---.  ,--.,--. ,--.,--. ,--.,--.
|  .-.  | |  .-.  | |  ||  | |  ||  | |  ||  |
`------'  `--' `--'  `----'   `----'   `----' 

:: PORTA PROJETO  :: 8086
:: PROJETO        :: chicken-api
:: PERFIL ATIVO   :: dev
:: ORGANIZAÃ‡ÃƒO    :: AutomatoDev
:: VERSÃƒO SPRING  :: 2.5.2
:: VERSÃƒO PROJETO :: 1.0.0-SNAPSHOT
:: DESCRIÃ‡ÃƒO      :: Projeto feito pensando em frangos

```

  Thanks for reading!!
  
  
