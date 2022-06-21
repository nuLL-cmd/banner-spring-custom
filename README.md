# Lib Banner Spring boot

### Sobre a lib

Dependência dedicada a exibir um banner personalizado substituindo o banner original de aplicações SpringBoot

A lib oferece visualização de um banner com amostra de sua escolha, assim como também mostra informações básicas sobre o projeto durante sua inicialização.

- PORTA DO PROJETO
- NOME DO PROJETO
- PERFIL ATIVO 
- NOME DA ORGANIZAÇÃO
- VERSÃO DO SPRINGBOOT 
- VERSÃO DO PROJETO 
- DESCRIÇÃO DO PROJETO

***As informações acimas podem ser facilmente personalizadas, assim como também é possível contribuir adicionando novas informações***.

### Dependência

Link: [Artifact](https://github.com/nuLL-cmd/banner-spring-custom/packages/)<br>

### Utilização

Para que a dependência exiba os dados no console, é necessário que algumas informações sobre a aplicação estejam presentes no arquivo ***properties*** default do projeto.

Exemplo usando .yaml:

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
>app.description=@project.description@
>app.organization=@project.organization.name@    
>app.context-path=@project.artifactId@
>```

Após realizar tais configurações, basta setar o banner no método main da aplicação que a configuração default será aplicada:

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

Você pode também usar seu próprio banner personalizado usando o método <font color="orange">setCustomBanner()</font>

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

O resultado obtido no console do catalina será algo como a saída abaixo.

```LOG
,-----.   ,--.
|  |) /_  |  ,---.  ,--.,--. ,--.,--. ,--.,--.
|  .-.  | |  .-.  | |  ||  | |  ||  | |  ||  |
`------'  `--' `--'  `----'   `----'   `----' 

:: PORTA PROJETO  :: 8086
:: PROJETO        :: chicken-api
:: PERFIL ATIVO   :: dev
:: ORGANIZAÇÃO    :: AutomatoDev
:: VERSÃO SPRING  :: 2.5.2
:: VERSÃO PROJETO :: 1.0.0-SNAPSHOT
:: DESCRIÇÃO      :: Projeto feito pensando em frangos

```

  Thanks for reading!!
  
  
