# Projeto NBA - Jogadores & Times 

Este documento explica de forma detalhada a arquitetura, os conceitos e a configuração do projeto, sem incluir os trechos de código, para que você possa apresentá-lo em sala de aula de forma clara e objetiva.

---

## 1. Visão Geral do Projeto

- **Objetivo:**  
  O projeto consiste em uma aplicação web que gerencia jogadores da NBA e seus times. A aplicação permite realizar operações de criação, leitura, atualização e exclusão (CRUD) para as duas entidades principais: Jogador e Time.

- **Principais Recursos:**
    - **CRUD para Jogadores e Times:** Permite inserir, listar, editar e excluir dados.
    - **Internacionalização (i18n):** A aplicação suporta múltiplos idiomas, possibilitando alternar facilmente entre, por exemplo, Português e Inglês.
    - **Validação de Dados:** Utiliza o Bean Validation para garantir que os dados inseridos atendam aos critérios definidos (por exemplo, campos obrigatórios e idade mínima).
    - **Interface Responsiva:** Utiliza o framework Bootstrap para garantir que a interface se ajuste a diferentes tamanhos de tela e proporcione uma aparência moderna.

---

## 2. Estrutura do Projeto

- **Organização de Pacotes:**  
  O projeto segue uma estrutura modular e organizada em pacotes, que inclui:
    - **Model:** Contém as entidades que representam os dados (Jogador e Time).
    - **Repository:** Define as interfaces para acesso e persistência dos dados.
    - **Service:** Abriga a lógica de negócio, realizando operações e interagindo com os repositórios.
    - **Controller:** Define as rotas e gerencia as requisições HTTP, integrando a lógica de negócio aos templates.
    - **Config:** Inclui as configurações especiais, como a configuração da internacionalização.

- **Pasta de Recursos:**  
  Os recursos não-Java estão localizados em:
    - **Templates:** Contém os arquivos HTML renderizados pelo Thymeleaf. Aqui também estão os “fragments” (como header e footer) que são reutilizados em várias páginas.
    - **Internationalization:** Armazena os arquivos com as mensagens de texto para cada idioma (por exemplo, um arquivo para Português e outro para Inglês).
    - **Static:** Possui arquivos estáticos, como folhas de estilo CSS, que complementam o design provido pelo Bootstrap.

---

## 3. Internacionalização 

- **Conceito:**  
  Internacionalização permite que a aplicação apresente conteúdos e mensagens de acordo com o idioma do usuário. Essa funcionalidade é crucial para ampliar o alcance do aplicativo para públicos que falam idiomas diferentes.

- **Como é Configurado no Projeto:**
    - Um **LocaleResolver** é definido para determinar o idioma padrão da aplicação (nesse caso, “pt_BR”).
    - Um **LocaleChangeInterceptor** permite que o usuário altere o idioma ao incluir um parâmetro (por exemplo, “lang=en”) na URL.
    - Um **MessageSource** é configurado para carregar os arquivos de mensagens a partir de um diretório específico e utilizar um determinado encoding. Com isso, as chaves definidas nos arquivos de mensagem são automaticamente resolvidas e apresentadas conforme o idioma escolhido.

- **Arquivos de Mensagens:**  
  São criados arquivos específicos para cada idioma (por exemplo, um para Português e outro para Inglês) e contêm as chaves e valores para textos da interface, mensagens de validação e rótulos.

---

## 4. Validação dos Dados

- **Objetivo da Validação:**  
  As validações garantem que os usuários insiram informações válidas. Por exemplo, campos obrigatórios não podem ficar vazios e a idade de um jogador deve ser maior ou igual a 18.

- **Mecanismo Utilizado:**  
  A validação é realizada utilizando o Bean Validation (Hibernate Validator). As entidades possuem anotações que especificam as regras (como “@NotEmpty” e “@Min”), e os textos das mensagens de erro são definidos usando chaves que serão resolvidas através do mecanismo de internacionalização.

- **Separação entre Rótulos e Mensagens de Erro:**  
  É importante que os rótulos exibidos nos formulários (ex.: “Nome do time” ou “Cidade”) não incluam a mensagem de erro de validação. Assim, os labels utilizam chaves separadas, enquanto as mensagens de validação apresentam textos como “Campo obrigatório” somente quando a validação falha.

---

## 5. Templates Thymeleaf e Uso do Bootstrap

- **Thymeleaf:**  
  É o motor de templates utilizado para gerar as páginas HTML dinâmicas. Ele permite incluir dados do back-end diretamente nas páginas, trabalhar com expressões de internacionalização (usando a sintaxe `#{}`) e reutilizar componentes com os “fragments” (como header e footer).

- **Bootstrap:**  
  Utilizado via CDN, o Bootstrap proporciona um design moderno e responsivo. A aplicação utiliza as classes utilitárias do Bootstrap para estruturar o layout (por exemplo, uso do sistema de grid e classes flexíveis que mantêm o footer sempre no final da página).

- **Estrutura dos Templates:**
    - **Home:** Exibe uma introdução à aplicação e links para trocar o idioma.
    - **Formulários de Jogador e Time:** Cada formulário contém campos com rótulos (exibindo somente o nome do campo, conforme definido nas chaves de rótulo) e áreas para exibição de mensagens de erro (que são ativadas somente quando a validação falha).
    - **Fragmentos:** O header contém a barra de navegação e o footer contém o rodapé. Esses componentes são reutilizados em todas as páginas para manter a consistência visual.

---

## 6. Fluxo de Funcionamento

1. **Inicialização da Aplicação:**  
   Ao iniciar, o Spring Boot configura todos os componentes, incluindo os resolvers de idioma, MessageSource e os interceptadores. A aplicação lê os arquivos de mensagens e define o idioma padrão (por exemplo, pt_BR).

2. **Interação do Usuário:**
    - Quando o usuário acessa a aplicação, a página inicial (home) é exibida com os textos definidos no idioma padrão.
    - Se o usuário clicar em um link para mudar de idioma, um parâmetro na URL (como `?lang=en`) faz com que o LocaleChangeInterceptor atualize o locale, e a interface passa a exibir os textos do arquivo de mensagens correspondente.

3. **Envio de Formulários:**
    - Ao preencher um formulário (seja para Jogador ou Time) e submeter, os dados são validados automaticamente com base nas anotações das entidades.
    - Caso algum campo obrigatório esteja vazio ou não cumpra os requisitos, as mensagens de erro são geradas utilizando as chaves definidas e são exibidas na mesma página, permitindo que o usuário corrija as informações.

4. **Exibição Dinâmica:**  
   Os templates Thymeleaf processam e exibem os dados, os erros e as mensagens traduzidas de acordo com o idioma selecionado pelo usuário.

---

## 7. Resumo

- **Arquitetura Modular:**  
  A separação entre modelos, controllers, serviços e repositórios torna o sistema organizado e de fácil manutenção.

- **Internacionalização (i18n):**  
  Permite a troca dinâmica entre idiomas (Português e Inglês), garantindo que os textos e mensagens da aplicação se adaptem ao usuário. Isso é feito por meio de um MessageSource configurado para carregar arquivos de mensagem e a utilização de LocaleResolvers e LocaleChangeInterceptors.

- **Validação com Mensagens Personalizadas:**  
  A utilização de Bean Validation assegura que os dados sejam consistentes, e as mensagens de erro são definidas de forma a serem apresentadas de maneira clara, separadas dos rótulos dos campos.

- **Interface Responsiva com Bootstrap:**  
  O uso do Bootstrap integra um design moderno e responsivo, com componentes reutilizáveis, garantindo uma boa experiência do usuário em diversos dispositivos.

- **Fluxo Interativo:**  
  A aplicação permite ao usuário interagir de forma intuitiva, desde a navegação, alteração de idioma, até o gerenciamento de dados via formulários com validação e feedback imediato.


