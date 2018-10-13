
package prueba;

public class Pelicula {
    private String titulo;
    private String cliente;
    private boolean prestado;
    
    //Respuesta 1
    public Pelicula(String titulo){
        this.titulo=titulo;
        this.prestado=false;
    }

    //Respuesta 2
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
   
    
    //Respuesta 3
    public void presta(String cliente)throws YaPrestada{
        if(prestado){
            throw new YaPrestada("La pelicula ya esta prestada");
        }else{
            //guardo que cliente la toma prestada
            setCliente(cliente);
            setPrestado(true);
            System.out.println("La pelicula fue prestada con exito");
        }
    }//fin presta
    
    
    //Respuesta 4
    public void devuelve(String cliente) throws ClienteIncorrecto, NoPrestada{
        if(!(getCliente().equals(cliente))){
            throw new ClienteIncorrecto("Este cliente no tomo la pelicula");
        }
        if(isPrestado()==false){
            throw new NoPrestada("La pelicula no esta prestada");
        }
        
        if((getCliente().equals(cliente)) && isPrestado()){
            setCliente("");
            setPrestado(false);
            System.out.println("La pelicula fue devuelta con exito");
        }
        
    }//fin funcion devuelve una pelicula
    
    
  
    
}//fin clase
