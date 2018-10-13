
package prueba;

import java.util.ArrayList;


public class VideoClub {
    
    private ArrayList<Pelicula> accion = new ArrayList<Pelicula>();
    private ArrayList<Pelicula> suspenso= new ArrayList<Pelicula>();
    private ArrayList<Pelicula> comedia= new ArrayList<Pelicula>();
    private ArrayList<Pelicula> drama = new ArrayList<Pelicula>();
    
    public VideoClub(){
        
    }

   
    
    public void añadirPelicula(Pelicula p,String genero) throws PeliculaExistente{
        int check=0;
        if(genero.equals("accion")){
            check=accion.indexOf(p);
            if(check<0){
                accion.add(p);
            }
        }
        if(genero.equals("suspenso")){
            check=suspenso.indexOf(p);
            if(check<0){
                suspenso.add(p);
            }
        }
        if(genero.equals("comedia")){
            check=comedia.indexOf(p);
            if(check<0){
                comedia.add(p);
            }
        }
        if(genero.equals("drama")){
            check=drama.indexOf(p);
            if(check<0){
                drama.add(p);
            }
        }
        if(check>=0){
            throw new PeliculaExistente("La pelicula ya existe");
        }
        
    }
    
    private Pelicula buscaPelicula(String titulo,String genero){
        boolean encontro=false;
        if(genero.equals("accion")){
            
            for(int i=0;i<accion.size();i++){
                String aux= accion.get(i).getTitulo();
                if(aux.equals(titulo)){
                    encontro=true;
                    return accion.get(i);
                }
            }//fin recorrer accion
            
        }//fin accion
        
        if(genero.equals("suspenso")){
            
            for(int i=0;i<suspenso.size();i++){
                String aux= suspenso.get(i).getTitulo();
                if(aux.equals(titulo)){
                    encontro=true;
                    return suspenso.get(i);
                }
            }
            
        }//fin recorrer
        
        if(genero.equals("comedia")){
            
          for(int i=0;i<comedia.size();i++){
                String aux= comedia.get(i).getTitulo();
                if(aux.equals(titulo)){
                    encontro=true;
                    return comedia.get(i);
                }
          }
            
        }//fin recorrer
        
        if(genero.equals("drama")){
            
            for(int i=0;i<drama.size();i++){
                String aux= drama.get(i).getTitulo();
                if(aux.equals(titulo)){
                    encontro=true;
                    return drama.get(i);
                    
                }
            }
        }//fin recorrer
        
        return null;
    }
    
    public void prestaPelicula(String titulo,String genero,String cliente) throws YaPrestada, NoExiste{
        if(buscaPelicula(titulo, genero)!=null){
            buscaPelicula(titulo, genero).presta(cliente);
        }
        if(buscaPelicula(titulo, genero)==null){
            throw new NoExiste("La pelicula no existe");
        }
    }
    
    public void eliminaPelicula(String titulo,String genero) throws NoExiste{
        if(buscaPelicula(titulo, genero)!=null){
            //si existe busca en que array esta y la elimina
            if(genero.equals("accion")){
            
                for(int i=0;i<accion.size();i++){
                    String aux= accion.get(i).getTitulo();
                    if(aux.equals(titulo)){
                        accion.remove(i);
                    }
                }//fin recorrer accion
            }//fin accion
        
            if(genero.equals("suspenso")){

                for(int i=0;i<suspenso.size();i++){
                    String aux= suspenso.get(i).getTitulo();
                    if(aux.equals(titulo)){
                        suspenso.remove(i);
                    }
                }

            }//fin recorrer

            if(genero.equals("comedia")){

              for(int i=0;i<comedia.size();i++){
                    String aux= comedia.get(i).getTitulo();
                    if(aux.equals(titulo)){
                        comedia.remove(i);
                    }
              }

            }//fin recorrer

            if(genero.equals("drama")){

                for(int i=0;i<drama.size();i++){
                    String aux= drama.get(i).getTitulo();
                    if(aux.equals(titulo)){
                        drama.remove(i);

                    }
                }
            }//fin recorrer
        }//fin existe la pelicula
        
        if(buscaPelicula(titulo, genero)==null){
            throw new NoExiste("La pelicula no existe");
        }
    }//fin eliminar pelicula
    
    public void devuelvePelicula(String titulo,String genero) throws NoExiste{
        if(buscaPelicula(titulo, genero)==null){
            throw new NoExiste("La pelicula no existe");
        }else{
            //si la pelicula existe busca en que array esta y setea el estado de prestado
            //a falso.
            if(genero.equals("accion")){
            
                for(int i=0;i<accion.size();i++){
                    String aux= accion.get(i).getTitulo();
                    if(aux.equals(titulo)){
                        accion.get(i).setPrestado(false);
                    }
                }//fin recorrer accion
            }//fin accion
        
            if(genero.equals("suspenso")){

                for(int i=0;i<suspenso.size();i++){
                    String aux= suspenso.get(i).getTitulo();
                    if(aux.equals(titulo)){
                        suspenso.get(i).setPrestado(false);
                    }
                }
            }//fin recorrer

            if(genero.equals("comedia")){

              for(int i=0;i<comedia.size();i++){
                    String aux= comedia.get(i).getTitulo();
                    if(aux.equals(titulo)){
                        comedia.get(i).setPrestado(false);
                    }
                }
            }//fin recorrer

            if(genero.equals("drama")){

                for(int i=0;i<drama.size();i++){
                    String aux= drama.get(i).getTitulo();
                    if(aux.equals(titulo)){
                        drama.get(i).setPrestado(false);
                    }
                }
            }//fin recorrer
        }
    }//fin devuelve pelicula
    public static void main(String[] args) throws PeliculaExistente {
        Pelicula p = new Pelicula("bambi");
        VideoClub k= new VideoClub();
        k.añadirPelicula(p, "accion");
        
    }
    
    
    
}//fin clase video club
