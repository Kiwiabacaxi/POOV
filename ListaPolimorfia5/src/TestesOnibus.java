// e) Crie a classe TestesOnibus com um método principal (main):
// – Crie um ônibus Hibrido e um OnibusGNV
// 	• OnibusGNV: alcance 200 milhas, nível de emissão 2, capacidade 50, custo $1 milhão
// 	• Hibrido: alcance 150 milhas, nível emissão 1, alta voltagem, capacidade 45, custo $1.2 milhão
// – Crie um ArrayList<Onibus>
// – Adicione os objetos a List
// – Perccora a List chamando getNivelEmissao() e getID() em cada elemento, mostrando os valores


// g) Crie um objeto OnibusEletrico no programa principal de TestesOnibus
// – Baixa voltagem, capacidade 55, custo $0.9 milhão
// 	• Adicione o objeto na List
// – Java tem uma palavra reservada instanceof
// 	if (o instanceof Eletrico) double t = ((Eletrico) o).getTensao();
// – Mostre a tensao e/ou nivelEmissao no laço, de acordo com cada objeto
// 	• Hibrido terá ambos, Eletrico apenas tensao, OnibusGNV apenas nivelEmissao

import java.util.ArrayList;

public class TestesOnibus {

    public static void main(String[] args) {
        OnibusGNV onibusGNV = new OnibusGNV(50, 1000000, 200, 2);
        Hibrido onibusHibrido = new Hibrido(45, 1200000, Eletrico.ALTA_VOLTAGEM, 150, 1);

        OnibusEletrico onibusEletrico = new OnibusEletrico(55, 900000, Eletrico.BAIXA_VOLTAGEM);

        ArrayList<Onibus> onibus = new ArrayList<>();

        onibus.add(onibusGNV);
        onibus.add(onibusHibrido);
        onibus.add(onibusEletrico);

        for (int i = 0; i < onibus.size(); i++) {
            if (onibus.get(i) instanceof Eletrico) {
                System.out.println("Tensão: " + ((Eletrico) onibus.get(i)).getTensao());
            }
            
            if (onibus.get(i) instanceof CombustivelLiquido) {
                System.out.println("Nível de emissão: " + ((CombustivelLiquido) onibus.get(i)).getNivelEmissao());
            }
            
            System.out.println("Index: " + i);
            System.out.println("ID: " + onibus.get(i).getID() + "\n");

        }

    }

}