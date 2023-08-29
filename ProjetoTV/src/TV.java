import java.security.InvalidParameterException;

public class TV {
    // no fun allowed
    // // tipos de tamanho
    // enum Tamanho {
    // POLEGADAS24, POLEGADAS28, POLEGADAS32, POLEGADAS40, POLEGADAS43, POLEGADAS50,
    // POLEGADAS55, POLEGADAS65,
    // POLEGADAS75, POLEGADAS85

    // }

    // // tipos de resolução - string
    // enum Resolucao {
    // RESOLUCAO720P, RESOLUCAO1080P, RESOLUCAO4K, RESOLUCAO8K, RESOLUCAO16K
    // }

    // Atributos
    private int tamanho; // em polegadas 24, 28, 32, 40, 43, 50, 55, 65, 75, 85
    private int canal; // >=0 && < 10000 (0 ... 9999)
    private int volume; // >= 0 && <= 100
    private boolean ligada; //
    private String resolucao; // 720p, 1080p, 1440p, 2160p, 4320p
    private boolean smart; // true ou false

    // Construtor padrao
    public TV() {
        System.out.println("Construtor padrao");
        tamanho = 40;
        canal = 3;
        volume = 50;
        ligada = true;
        resolucao = "1080p";
        smart = false;

    }

    // Construtor com parametros
    public TV(int tamanho, int canal, int volume, boolean ligada, String resolucao, boolean smart) {
        System.out.println("Construtor com parametros");
        setTamanho(tamanho);
        setCanal(canal);
        setVolume(volume);
        setLigada(ligada);
        setResolucao(resolucao);
        setSmart(smart);

    }

    // setters e getters
    // tamanho
    public void setTamanho(int tamanho) {
        if (tamanho == 24 || tamanho == 28 || tamanho == 32 || tamanho == 40 || tamanho == 43 || tamanho == 50
                || tamanho == 55 || tamanho == 65 || tamanho == 75 || tamanho == 85) {
            this.tamanho = tamanho;
        } else {
            throw new InvalidParameterException("Tamanho inválido");
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    // canal
    public void setCanal(int canal) {
        if (canal >= 0 && canal < 10000) {
            this.canal = canal;
        } else {
            throw new InvalidParameterException("Canal inválido");
        }
    }

    public int getCanal() {
        return canal;
    }

    // volume
    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
        } else {
            throw new InvalidParameterException("Volume inválido");
        }
    }

    public int getVolume() {
        return volume;
    }

    // ligada
    public void setLigada(boolean ligada) {
        this.ligada = ligada;
    }

    public boolean isLigada() {
        return ligada;
    }

    // resolucao
    public void setResolucao(String resolucao) {
        if (resolucao == "720p" || resolucao == "1080p" || resolucao == "1440p" || resolucao == "2160p"
                || resolucao == "4320p") {
            this.resolucao = resolucao;
        } else {
            throw new InvalidParameterException("Resolução inválida");
        }
    }

    public String getResolucao() {
        return resolucao;
    }

    // smart
    public void setSmart(boolean smart) {
        this.smart = smart;
    }

    public boolean isSmart() {
        return smart;
    }

    // Métodos

    // ligar
    public void ligar(){
        // se a tv estiver desligada, ligar
        if (ligada == false){
            ligada = true;
        } else {
            throw new InvalidParameterException("TV já está ligada");
        }
    }

    // desligar
    public void desligar(){
        // se a tv estiver ligada, desligar
        if (ligada == true){
            ligada = false;
        } else {
            throw new InvalidParameterException("TV já está desligada");
        }
    }

    // mudar canal
    public void mudarCanal(int canal){
        // se a tv estiver ligada, muda o canal
        if (ligada == true) {
            setCanal(canal);
        } else {
            throw new InvalidParameterException("TV está desligada");
        }
    }

    // aumentar o volume


    // mostrar informações
    public void mostrarInformacoes() {
        System.out.println("Tamanho: " + tamanho);
        System.out.println("Canal: " + canal);
        System.out.println("Volume: " + volume);
        System.out.println("Ligada: " + ligada);
        System.out.println("Resolução: " + resolucao);
        System.out.println("Smart: " + smart);
    }

}
