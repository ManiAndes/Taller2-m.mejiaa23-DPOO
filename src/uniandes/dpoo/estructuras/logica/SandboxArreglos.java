package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
        int[] copiaEnteros = this.arregloEnteros.clone();	
    	return copiaEnteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
        return this.arregloCadenas.clone();
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int cantidad = (this.arregloEnteros).length;
        return cantidad;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int cantidad = (this.arregloCadenas).length;
        return cantidad;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int[] newArray = new int[this.arregloEnteros.length + 1];
    	
    	for (int i = 0; i < this.arregloEnteros.length; i++) {
    		newArray[i] = this.arregloEnteros[i];
    	}
    	
    	newArray[newArray.length - 1] = entero;
    	
    	this.arregloEnteros = newArray;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] newArray = new String[this.arregloCadenas.length + 1];
    	
    	for (int i = 0; i < this.arregloCadenas.length; i++) {
    		newArray[i] = this.arregloCadenas[i];
    	}
    	
    	newArray[newArray.length - 1] = cadena;
    	
    	this.arregloCadenas = newArray;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int apariciones = 0;
    	
    	for (int n:this.arregloEnteros) {
    		if (n == valor) {
    			apariciones++;
    		}
    	}
    	
    	int[] newArray = new int[this.arregloEnteros.length - apariciones];
    	int pos = 0;
    	
    	for (int n:this.arregloEnteros) {
    		if (n != valor) {
    			newArray[pos] = n;
    			pos++;
    		}
    	}
    	
    	this.arregloEnteros = newArray;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int apariciones = 0;
    	
    	for (String str:this.arregloCadenas) {
    		if (str == cadena) {
    			apariciones++;
    		}
    	}
    	
    	String[] newArray = new String[this.arregloCadenas.length - apariciones];
    	int pos = 0;
    	
    	for (String str:this.arregloCadenas) {
    		if (str != cadena) {
    			newArray[pos] = str;
    			pos++;
    		}
    	}
    	
    	this.arregloCadenas = newArray;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int size = this.arregloEnteros.length;
    	
    	if (posicion >= size) {
    		agregarEntero(entero);
    	}
    	
    	else if (posicion < 0) {
        	int[] newArray = new int[this.arregloEnteros.length + 1];
        	
        	for (int i = 0; i < this.arregloEnteros.length; i++) {
        		newArray[i + 1] = this.arregloEnteros[i];
        	}
        	
        	newArray[0] = entero;
        	
        	this.arregloEnteros = newArray;
    	}
    	
    	else {
    		int[] newArray = new int[this.arregloEnteros.length + 1];
    		boolean inserted = false;
    		
    		for (int i = 0; i < this.arregloEnteros.length; i++) {
        		
    			if (i == posicion) {
    				newArray[i] = entero;
    				newArray[i + 1] = this.arregloEnteros[i];
    				inserted = true;
    			}
    			
    			else if (inserted == true) {
    				newArray[i + 1] = this.arregloEnteros[i];
    			}
    			
    			else {
    				newArray[i] = this.arregloEnteros[i];
    			}
        	}
        	
        	this.arregloEnteros = newArray;
    	}
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	int size = this.arregloEnteros.length;
    	
    	if (0 <= posicion && posicion < size) {
    		int[] newArray = new int[this.arregloEnteros.length - 1];
    		boolean removed = false;
    		
    		for (int i = 0; i < this.arregloEnteros.length; i++) {
        		
    			if (i == posicion) {
    				removed = true;
    			}
    			
    			else if (removed == true) {
    				newArray[i - 1] = this.arregloEnteros[i];
    			}
    			
    			else {
    				newArray[i] = this.arregloEnteros[i];
    			}
        	}
        	
        	this.arregloEnteros = newArray;
    	}
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] newArray = new int[valores.length];
    	
    	for (int i = 0; i < valores.length; i++) {
    		int entero = (int) valores[i];
    		
    		newArray[i] = entero;
    	}
    	
    	this.arregloEnteros = newArray;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] newArray = new String[objetos.length];
    	
    	for (int i = 0; i < objetos.length; i++) {
    		String str = objetos[i].toString();
    		
    		newArray[i] = str;
    	}
    	
    	this.arregloCadenas = newArray;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {	
    	for (int i = 0; i < this.arregloEnteros.length; i++) {
    		
    		if (this.arregloEnteros[i] < 0) {
    			int positivo = (-1) * this.arregloEnteros[i];
    			this.arregloEnteros[i] = positivo;
    		}
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(this.arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(this.arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int veces = 0;
    	
    	for (int n:this.arregloEnteros) {
    		if (n == valor) {
    			veces++;
    		}
    	}
    	
        return veces;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int veces = 0;
    	
    	for (String str:this.arregloCadenas) {
    		if (str.equalsIgnoreCase(cadena)) {
    			veces++;
    		}
    	}
    	
        return veces;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int apariciones = 0;
    	
    	for (int n:this.arregloEnteros) {
    		if (n == valor) {
    			apariciones++;
    		}
    	}
    	
    	int[] newArray = new int[apariciones];
    	int pos = 0;
    	
    	for (int i = 0; i < this.arregloEnteros.length; i++) {
    		if (this.arregloEnteros[i] == valor) {
    			newArray[pos] = i;
    			pos++;
    		}
    	}
    	
    	return newArray;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
        
    	if (this.arregloEnteros.length == 0) {
    		return new int[] {};
    	}
    	
    	else {
            int mayor = 0;
            int menor = 0;
            
            for (int i = 0; i < this.arregloEnteros.length; i++) {
            	int current = this.arregloEnteros[i];
            	
            	if (mayor == 0 && menor == 0) {
            		mayor = current;
            		menor = current;
            	}
            	
            	else if (mayor < current) {
            		mayor = current;
            	}
            	
            	else if (menor > current) {
            		menor = current;
            	}
            }
            
            return new int[] {menor, mayor};
    	}
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
        HashMap<Integer, Integer> histograma = new HashMap<Integer, Integer>();
        
        for (int n:this.arregloEnteros) {
        	if (histograma.containsKey(n)) {
        		int cantidad = histograma.get(n) + 1;
        		histograma.put(n, cantidad);
        	}
        	
        	else {
        		histograma.put(n, 1);
        	}
        }
    	
    	return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
        HashMap<Integer, Integer> histograma = calcularHistograma();
        int repetidos = 0;
        
        for (Map.Entry<Integer, Integer> pareja:histograma.entrySet()) {
        	if (pareja.getValue() > 1) {
        		repetidos++;
        	}
        }
        
        return repetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        boolean iguales = true;
        int i = 0;
        
        if (this.arregloEnteros.length != otroArreglo.length) {
        	iguales = false;
        }
        
        else {
            while (i < this.arregloEnteros.length && iguales == true) {
            	if (this.arregloEnteros[i] != otroArreglo[i]) {
            		iguales = false;
            	}
            }
        }
        
        return iguales;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
        boolean mismos = true;
        
        if (this.arregloEnteros.length != otroArreglo.length) {
        	mismos = false;
        }
        
        else {
            HashMap<Integer, Integer> histograma = calcularHistograma();
            
            for (Map.Entry<Integer, Integer> pareja:histograma.entrySet()) {
            	
            	int numero = pareja.getKey();
            	int cantidad = pareja.getValue();
            	
            	int vecesOtro = 0;
            	
            	for (int n:otroArreglo) {
            		if (n == numero) {
            			vecesOtro++;
            		}
            	}
            	
            	if (vecesOtro != cantidad) {
            		mismos = false;
            		break;
            	}
            }
        }
        
        return mismos;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int[] newArray = new int[cantidad];
    	
    	for (int i = 0; i < cantidad; i++) {
    		double rand = Math.random();
    		int num = (int) (rand * (maximo - minimo + 1)) + minimo;
    		newArray[i] = num;
    	}
    	
    	this.arregloEnteros = newArray;
    }

}
