/* package poov;

public class LampadaColorida extends Lampada {
    
    private String cor;

    public LampadaColorida() {
        super(220, 60);
        cor = "Sem cor";
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    // public void setTensao(int tensao) {
    //     System.out.println("Estraguei tudo");
    //     // super.setTensao(-1000);
    // }

    @Override  //o @Override nao eh obrigatorio, mas eh util
    public void mostrar() {
        // super.mostrar();
        // System.out.println(cor);
        String texto = cor + ", " + getTensao() + "V, " + getPotencia() + "W, " + ((isAcesa()) ? "Acesa" : "Apagada")
                + ((isQueimada()) ? ", Queimada" : "")
                + ((isQuebrada()) ? ", Quebrada" : "");
        System.out.println(texto);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + cor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((cor == null) ? 0 : cor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        LampadaColorida other = (LampadaColorida) obj;
        if (cor == null) {
            if (other.cor != null)
                return false;
        } else if (!cor.equals(other.cor))
            return false;
        return true;
    }

    

}


----------------------------------

package poov;

public class App {

    public static void main(String[] args) throws Exception {
        
        // LampadaColorida lc = new LampadaColorida();
        // // lc.mostrar();
        // lc.setCor("Azul");
        // // lc.mostrar();

        // System.out.println(lc);

        Lampada l1 = new Lampada();
        System.out.println(l1);

        Lampada l2 = new Lampada();
        System.out.println(l2);

        if (l1 == l2) { 
            System.out.println("iguais");
        } else {
            System.out.println("diferentes");
        }

        if (l1.equals(l2)) {
            System.out.println("iguais");
        } else {
            System.out.println("diferentes");
        }

        if (l1.equals(l1)) {
            System.out.println("iguais");
        } else {
            System.out.println("diferentes");
        }

        Lampada l3 = new Lampada(l1);
        

        // System.out.println();
        // Lampada l2 = new Lampada(110, 100);
        // System.out.println();
        // Lampada l3 = new Lampada(220, 60, true);
        // l1.mostrar();

        // l1.setTensao(220);
        // l1.setPotencia(150);
        // // l1.setAcesa(true);
        // l1.quebrar();
        // // l1.setQueimada(true);
        // l1.acender();
        // l1.mostrar();

        // Lampada l2 = new Lampada(220, 60);
        // l2.quebrar();
        // l2.mostrar();

        // Lampada l3 = new Lampada(110, 60, true);
        // l3.mostrar();


        // //Total de potencia gasta pelas 3 lampadas
        // System.out.println(l1.getPotencia() + l2.getPotencia() + l3.getPotencia());

    }

}
 */