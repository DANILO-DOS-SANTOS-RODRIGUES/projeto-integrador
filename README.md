# projeto-integrador
Software de gerenciamento de poupança.

Validações
[x] Não deixar salvar uma cateira com o mesmo nome;
[x] Não deixar salvar uma pessoa com o mesmo cpf ou identidade;
[x] Não deixar salvar uma pessoa com o mesmo numero da casa;
[x] Não deixar salvar uma taxa com o mesmo nome;
[x] Não deixar salvar um documento com o mesmo cpf ou identidade;
[x] Não deixar salvar um endereço com o mesmo cep.
 
Forma de fazer a validação

        List<Carteira> listaDeCarteiras = carteiraRepository.findAll(); 

        for(Carteira nomeCarteira : listaDeCarteiras){
            if(carteira.getNome().equals(nomeCarteira.getNome())){
                throw new Exception("Esse nome ja existe, insira outro nome");
            }
        }
        
        
        ![diagrama](https://user-images.githubusercontent.com/106254231/201235789-f418fa12-b407-4d5f-afe0-505d51b8163c.svg)
