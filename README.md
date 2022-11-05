# ToDoList_app
App To Do List em java, utilizando CRUD com MySQL e padrão MVC.

Utilizando a linguagem JAVA o aplicativo To Do List foi criado para facilitar as anotações que desejamos fazer no dia a dia.
As informações inseridas no aplicativo permanecem salvas, pois está conectado ao banco de dados MySQL.

O aplicativo consiste em fazer CRUD (Create, read, update, delete) em um banco de dados.
A orientação a objetos e o padrão MVC (Model, View, Controller) foram utilizados para o desenvolvimento do app,
onde classe View é a interface com o usuário, a classe Controller possui toda lógica de validação e chamada de métodos, fazendo a conexão entre as classes,
e a classe Model recebe as informações e interage com o banco de dados.

Obs: Para funcionar o código, deve-se configurar com seu banco de dados local.
O app não cria um novo banco de dados, utiliza de um banco ja existente para armazenar, consultar, atualizar e deletar as atividades.
A conexão do Java com o MySQL foi feita através do Driver de conexão JDBC MySQL.

Estruturação do banco de dados:
Nome do banco de dados: todo
Nome da tabela: tarefas
Descrição das colunas da tabela: id varchar(255) not null primary key, nome varchar(255) not null, verificado boolean not null.
