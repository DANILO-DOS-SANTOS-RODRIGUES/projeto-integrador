# projeto-integrador
Software de gerenciamento de poupança.

Validações

[x] Não deixar salvar uma cateira com o mesmo nome;
[ ] Não deixar salvar uma pessoa com o mesmo cpf ou identidade;
[ ] Não deixar salvar uma pessoa com o mesmo numero da casa;
[ ] Não deixar salvar uma taxa com o mesmo nome;
[ ] Não deixar salvar um documento com o mesmo cpf ou identidade;

        List<Carteira> listaDeCarteiras = carteiraRepository.findAll(); função para salvar

        for(Carteira nomeCarteira : listaDeCarteiras){
            if(carteira.getNome().equals(nomeCarteira.getNome())){
                throw new Exception("Esse nome ja existe, insira outro nome");
            }
        }