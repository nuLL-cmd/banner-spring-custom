package br.com.nuLLcmd;

import java.io.PrintStream;
import java.util.Objects;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/*
 *
 * https://stackoverflow.com/questions/44026687/show-custom-variable-in-spring-boot-banner
 *
 */     
@Service
public class CustomBanner implements Banner {

    private String[] customBanner = new String[]{};

    private final String[] BANNER = {
        "\n\n _     _  ______  _        _         _____",   
        "(_)   (_)(______)(_)      (_)       (_____)",  
        "(_)___(_)(_)___  (_)      (_)      (_)   (_)", 
        "(_______)(_____) (_)      (_)      (_)   (_)", 
        "(_)   (_)(_)____ (_)____  (_)____  (_)___(_)", 
        "(_)   (_)(______)(______) (______)  (_____)",  
        "                                              \n"
    };

    private final String PORTA_PROJETO = ":: PORTA PROJETO  :: ";
    private final String PROJETO = ":: PROJETO        :: ";
    private final String PERFIL_AIVO = ":: PERFIL ATIVO   :: ";
    private final String ORGANIZACAO = ":: ORGANIZAÇÃO    :: ";
    private final String SPRING_BOOT = ":: VERSÃO SPRING  :: ";
    private final String APP_VERSAO = ":: VERSÃO PROJETO :: ";
    private final String DESCRICAO = ":: DESCRIÇÃO      :: ";

    /* ------------------------------------------------------------------------------------------------------*/

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
        
        for (String line : customBanner.length != 0 ? customBanner : BANNER) {
                  printStream.println(AnsiOutput.toString(AnsiColor.BRIGHT_RED, line));
            }

        String porta = this.validaPropriedade(environment, "server.port");
        String organizacao = this.validaPropriedade(environment, "app.organization");
        String nome = this.validaPropriedade(environment, "app.name");
        String perfilAtivo = this.validaPropriedade(environment, "spring.profiles.active");
        String projetoVersao = this.validaPropriedade(environment, "app.version");
        String descricao = this.validaPropriedade(environment, "app.description");

   
        imprimirNoBanner(printStream, PORTA_PROJETO, porta, AnsiColor.GREEN);
        imprimirNoBanner(printStream, PROJETO, nome, AnsiColor.BRIGHT_BLUE);
        imprimirNoBanner(printStream, PERFIL_AIVO, perfilAtivo, AnsiColor.BRIGHT_MAGENTA);
        imprimirNoBanner(printStream, ORGANIZACAO, organizacao, AnsiColor.BRIGHT_RED);
        imprimirNoBanner(printStream, SPRING_BOOT, SpringBootVersion.getVersion(), AnsiColor.BRIGHT_CYAN);
        imprimirNoBanner(printStream, APP_VERSAO,projetoVersao, AnsiColor.BRIGHT_YELLOW);
        imprimirNoBanner(printStream, DESCRICAO,descricao, AnsiColor.RED);
        System.out.println("\n");
    }

    /* ------------------------------------------------------------------------------------------------------*/


    private void imprimirNoBanner(PrintStream printStream, String titulo, String propriedade, AnsiColor corPropriedade) {

        String padding = "";

               printStream.println(
                        AnsiOutput.toString(
                                AnsiColor.WHITE,
                                titulo,
                                corPropriedade,
                                padding,
                                AnsiStyle.FAINT,
                                propriedade));
    }

    /* ------------------------------------------------------------------------------------------------------*/

    private String validaPropriedade(Environment environment, String propriedade) {

        if(Objects.isNull(environment)) {

                return "N/A";
        }

        if(Objects.nonNull(environment.getProperty(propriedade))) {
                return environment.getProperty(propriedade);
        }

        return "N/A";

    }

    /* ------------------------------------------------------------------------------------------------------*/

    public void setCustomBanner(String[] customBanner) {

        if(Objects.nonNull(customBanner)) {

            this.customBanner = customBanner;
        }
    }

    /* ------------------------------------------------------------------------------------------------------*/

}
