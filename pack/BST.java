package pack;

public class BST {
    private Node root = new Node();
    private int alturaAux = 0;
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    } 
    
    public void insert(int k, String v){
        this.insert(this.root, k, v);
    }

    private Node insert(Node subroot, int k, String v){
        if(subroot == null){
            Node n = new Node(k,v);
            n.setAltura(alturaAux);
            return n;
        }else if(subroot.getValue()==null){
            subroot.setValue(v);
            subroot.setKey(k);
        }else if (k<subroot.getKey()){
            alturaAux++;
            subroot.setLeft(this.insert(subroot.getLeft(), k, v));
            alturaAux = 0;
        }else if(k>subroot.getKey()){
            alturaAux++;
            subroot.setRight(this.insert(subroot.getRight(),k,v));
            alturaAux = 0;
        }
        return subroot;
    }

    public String get (int k){
        return this.get(this.root,k);
    }

    private String get(Node sub, int k){
        if (sub != null){
            if(k<sub.getKey()){
                return this.get(sub.getLeft(),k);
            }else if (k>sub.getKey()){
                return this.get(sub.getRight(),k);
            }else{
                return sub.getValue();
            }
        }
        return null;
    }

    public void set (int k, String value){
        this.set(this.root,k,value);
    }

    private void set(Node sub, int k, String v){
        
    }

    public void inOrder (){
        this.inOrder(this.root);
    }

    private void inOrder(Node sub){
        if(sub!=null){
            this.inOrder(sub.getLeft());
            System.out.println("Chave: " + sub.getKey() + ", Valor: " + sub.getValue() + ", Altura: " + sub.getAltura());
            this.inOrder(sub.getRight());
        }
    }

    public void BuscaProfundidade(int k){
        this.BuscaProfundidade(this.root,k);//fazendo a recursividade
    }

    private void BuscaProfundidade(Node root, int k){
        boolean aux = false;
        if(root!=null ){//so entra no laço se a arvore existir
            System.out.println("Chave: " + root.getKey() + " visitada");
            if (aux == false){//boolean para auxiliar
                if (root.getLeft() != null){//se n tiver um filho do lado esquerdo ele n entra
                    BuscaProfundidade(root.getLeft(), k);//chama a função com o filho no parametro
                }
                if (root.getRight() != null){// se n tiver um filho do lado direito ele n entra
                    BuscaProfundidade(root.getRight(), k);//chama a funcao com o filho no parametro
                }
            }
            System.out.println("Chave: " + root.getKey() + " acessada");
            if(root.getKey()== k){
                System.out.println("Chave: " + root.getKey() + " encontrada, Valor: " + root.getValue());// se encontrar a chave o aux vira true para poder pular os lacos a cima
                aux = true;
            }
        }
    }
    public void BuscaLargura(int k){
        this.BuscaLargura(this.root, k);
    }
    
    boolean aux = false;
    int i = 0;
    
    private void BuscaLargura(Node n, int k){
        while(aux == false || i <= alturaMax(this.root)){
            codiguin(n,k,i);
            i++;
        }
    }
    private void codiguin(Node n, int k, int i){
        if (n != null){
            System.out.println("Chave: " + n.getKey() + " na altura: " + n.getAltura()+" visitada");
            if(i==0){
                System.out.println("Chave: " + n.getKey() + " na altura: " + n.getAltura()+" acessada");
                if(n.getKey() == k){
                    aux = true;
                    System.out.println("Chave: " + n.getKey() + " encontrada, Valor: " + n.getValue());
                } 
            }else if (aux != true){
                codiguin(n.getLeft(), k, i-1);
                codiguin(n.getRight(), k, i-1);
            }
        }
    }

    int valor = 0;

    private int alturaMax(Node n){ //verifica a altura da arvore encontrando o maior numero de altura
        if(n != null){
            if(n.getAltura()>valor)
                valor = n.getAltura();
            alturaMax(n.getLeft());
            alturaMax(n.getRight());
        }
        return valor;
    }
}