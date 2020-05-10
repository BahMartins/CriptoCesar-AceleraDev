package challenge;

public class CriptografiaCesariana implements Criptografia {

    int chave = 3;
    char primeiraLetra = 'a';
    char ultimaLetra = 'z';

    @Override
    public String criptografar(String texto) {

        CapitudaErros(texto);

        String novaFrase = new String();

        String fraseMinuscula = texto.toLowerCase();

        for (int i = 0; i < fraseMinuscula.length(); i++){

            if (fraseMinuscula.charAt(i) >= primeiraLetra && fraseMinuscula.charAt(i) < ultimaLetra){
                int fraseCriptografada = fraseMinuscula.charAt(i) + chave;
                novaFrase = novaFrase.concat(String.valueOf((char) fraseCriptografada));
            }else {
                novaFrase = novaFrase.concat(String.valueOf(fraseMinuscula.charAt(i)));
            }
        }
        return novaFrase;
    }

    @Override
    public String descriptografar(String texto) {

        CapitudaErros(texto);

        String novaFrase = new String();

        String fraseMinuscula = texto.toLowerCase();

        for (int i = 0; i < fraseMinuscula.length(); i++){
            if (fraseMinuscula.charAt(i) >= primeiraLetra && fraseMinuscula.charAt(i) < ultimaLetra){
                int fraseDescriptografada = fraseMinuscula.charAt(i) - chave;
                novaFrase = novaFrase.concat(String.valueOf((char) fraseDescriptografada));
            } else {
                novaFrase = novaFrase.concat(String.valueOf(fraseMinuscula.charAt(i)));
            }
        }
        return novaFrase;

    }

    private void CapitudaErros(String texto){
        if (texto.isEmpty()) {
            System.out.println("Frase Vazia");
            throw new IllegalArgumentException();
        }
        if(texto == null){
            System.out.println("Frase Nula");
            throw new NullPointerException();
        }
    }

}
