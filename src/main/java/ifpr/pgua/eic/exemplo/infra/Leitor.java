package ifpr.pgua.eic.exemplo.infra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ifpr.pgua.eic.exemplo.models.Veiculo;

public class Leitor {
    public ArrayList<Veiculo> carregar(String nomeArquivo){
        ArrayList<Veiculo> lista = new ArrayList<>();
        
        try{
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            while(linha!=null){
                
                String[] split = linha.split(";");
                String placa = split[0];
                String modelp = split[1];
                String fabricante = split[2];
                String anoFabri = split[3];
                String cor = split[4];

                Veiculo v = new Veiculo(placa, modelp, fabricante, Integer.valueOf(anoFabri), cor);
                
                lista.add(v);

                linha = br.readLine();
            }
            br.close();
            fr.close();

        }catch(IOException err){
            System.out.println(err.getMessage());
        }

        return lista;
    }
}
