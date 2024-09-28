import java.util.*;
import java.util.stream.Collectors;

public class Desafio {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(-1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3, 15, 30);

//      Desafio 1 - Mostre a lista na ordem numérica:
//      Crie um programa que utilize a Stream API para ordenar a lista de números em ordem crescente e a exiba no console.
        System.out.println("Mostre a lista na ordem númerica: ");
        List<Integer> numerosOrdemNatural = numeros.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(numerosOrdemNatural);

//        Desafio 2 - Imprima a soma dos números pares da lista:
//        Utilizando a Stream API, realize a soma dos números pares da lista e exiba o resultado no console.
        int somaDosNumerosPares = numeros.stream()
                .filter(i -> (i % 2 == 0))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Imprima a soma dos números pares da lista: " + somaDosNumerosPares);


//      Verificando se todos os números são positivos
//      Com a ajuda da Stream API, verifique se todos os números da lista são positivos e exiba o resultado no console.
        boolean todosPositivos = numeros.stream()
                .allMatch(num -> num > 0);


        if(todosPositivos) {
            System.out.println("Todos os números são positivos.");
        } else {
            System.out.println("Nem todos os números são positivos.");
        }

//        Desafio 4 - Remova todos os valores ímpares:
//        Utilize a Stream API para remover os valores ímpares da lista e imprima a lista resultante no console.

        System.out.println("Imprime todos os elementos pares da lista!");
        numeros.forEach(n -> {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
        });
        System.out.println();

//        Desafio 5 - Calcule a média dos números maiores que 5:
//        Com a Stream API, calcule a média dos números maiores que 5 e exiba o resultado no console.
        OptionalDouble media = numeros.stream()
                .filter(num -> num > 5)  // Filtra números maiores que 5
                .mapToInt(Integer::intValue)  // Converte Integer para int
                .average();  // Calcula a média

        if (media.isPresent()) {
            System.out.println("A média dos números maiores que 5 é: " + media.getAsDouble());
        }

//        Desafio 6 - Verificar se a lista contém algum número maior que 10:
//        Utilize a Stream API para verificar se a lista contém algum número maior que 10 e exiba o resultado no console.
        System.out.println("Lista dos número maior que 10: ");
        numeros.forEach(n -> {
            if (n > 10) {
                System.out.print(n + " ");
            }
        });
        System.out.println();

//        Desafio 7 - Encontrar o segundo número maior da lista:
//        Com a ajuda da Stream API, encontre o segundo número maior da lista e exiba o resultado no console.

        Optional<Integer> segundoMaior = numeros.stream()
                .distinct() // Remove duplicatas
                .sorted((a,b) -> b -a) // Ordena em ordem decrescente
                .skip(1)  // Pula o maior (primeiro elemento)
                .findFirst(); // Pega o segundo maior

        System.out.println("Segundo número maior da lista: " + segundoMaior.get());

//        Desafio 8 - Somar os dígitos de todos os números da lista:
//        Utilizando a Stream API, realize a soma dos dígitos de todos os números da lista e exiba o resultado no console.

        int somaDosNumeros = numeros.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Somar os dígitos de todos os números da lista: " + somaDosNumeros);

        // Verificando se todos os números são distintos
        boolean todosDistintos = numeros.stream()
                .allMatch(new HashSet<>()::add); // Usando um Set para verificar duplicatas

        if (todosDistintos) {
            System.out.println("Todos os números são distintos.");
        } else {
            System.out.println("Nem todos os números são distintos.");
        }

//        Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5:
//        Utilize a Stream API para agrupar os valores ímpares múltiplos de 3 ou de 5 e exiba o resultado no console.
        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosOrdemNatural.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumerosMultiplosDe3E5);

//        Desafio 11 - Encontre a soma dos quadrados de todos os números da lista:
//        Utilizando a Stream API, encontre a soma dos quadrados de todos os números da lista e exiba o resultado no console.

        // Calculando a soma dos quadrados de todos os números da lista
        int somaQuadrados = numeros.stream()
                .map(num -> num * num)  // Eleva cada número ao quadrado
                .mapToInt(Integer::intValue)  // Converte para int primitivo
                .sum();  // Soma todos os valores

        // Exibindo o resultado no console
        System.out.println("A soma dos quadrados de todos os números é: " + somaQuadrados);

//        Desafio 12 - Encontre o produto de todos os números da lista:
//        Com a ajuda da Stream API, encontre o produto de todos os números da lista e exiba o resultado no console.
        Optional<Integer> produto = numeros.stream()
                .reduce((num1, num2) -> num1 * num2);  // Multiplica todos os números


        if (produto.isPresent()) {
            System.out.println("O produto de todos os números é: " + produto.get());
        } else {
            System.out.println("A lista está vazia, portanto não há produto.");
        }


//        Desafio 13 - Filtrar os números que estão dentro de um intervalo:
//        Utilize a Stream API para filtrar os números que estão dentro de um intervalo específico (por exemplo, entre 5 e 10) e exiba o resultado no console.
        int limiteInferior = 5;
        int limiteSuperior = 10;

        // Filtrando os números que estão dentro do intervalo [5, 10]
        List<Integer> numerosFiltrados = numeros.stream()
                .filter(num -> num >= limiteInferior && num <= limiteSuperior)  // Aplica o filtro
                .toList();  // Coleta o resultado como uma lista


        System.out.println("Números dentro do intervalo [" + limiteInferior + ", " + limiteSuperior + "]: " + numerosFiltrados);


//        Desafio 14 - Encontre o maior número primo da lista:
//        Com a Stream API, encontre o maior número primo da lista e exiba o resultado no console.
        numeros.stream()
                .filter(n -> {
                    if (n <= 1) return false;
                    for (int i = 2; i <= Math.sqrt(n); i++) {
                        if (n % i == 0) return false;
                    }
                    return true;
                })
                .max(Comparator.naturalOrder())
                .ifPresentOrElse(n-> System.out.println("Maior numero primo da lista: "+n),()-> System.out.println("Não foi encontrado numeros primos"));


        boolean contenNegativo = numeros.stream()
                .anyMatch(num -> num < 0);

//        Desafio 15 - Verifique se a lista contém pelo menos um número negativo:
//        Utilizando a Stream API, verifique se a lista contém pelo menos um número negativo e exiba o resultado no console.
        if(contenNegativo) {
            System.out.println(" Lista contém pelo menos um número negativo:");
        } else {
            System.out.println(" lista não contém número negativo:");
        }

//        Desafio 16 - Agrupe os números em pares e ímpares:
//        Utilize a Stream API para agrupar os números em duas listas
//        separadas, uma contendo os números pares e outra contendo os
//        números ímpares da lista original, e exiba os resultados no console.
        Map<Boolean, List<Integer>> groups =
                numeros.stream()
                        .collect(Collectors.groupingBy(i -> i % 2 == 0));
        groups.computeIfAbsent(true, k -> List.of());    // acrescentei isso aqui só para o caso de não haver números pares
        groups.computeIfAbsent(false, k -> List.of());   // ou ímpares na lista original

        System.out.println("Pares: " + groups.get(true));
        System.out.println("Ímpares: " + groups.get(false));

//        Desafio 17 - Filtrar os números primos da lista:
//        Com a ajuda da Stream API, filtre os números primos da lista e exiba o
//        resultado no console.

        System.out.print("Numeros primos da lista: "+numeros.stream()
                .filter(n -> {
                    if (n <= 1) return false;
                    for (int i = 2; i <= Math.sqrt(n); i++) {
                        if (n % i == 0) return false;
                    }
                    return true;
                })
                .toList());
        System.out.println();

//        Desafio 18 - Verifique se todos os números da lista são iguais:
//        Utilizando a Stream API, verifique se todos os números da lista são
//        iguais e exiba o resultado no console.

        // Agrupa os números com base no próprio número.
        System.out.println("Verifique se todos os números da lista são iguais: ");
        Map<Integer, List<Integer>> grupos = numeros.stream()
                .collect(Collectors.groupingBy(num -> num));
        // Você pode ver que temos a indicação quais são os números que se repetem observando chave - valor.
        System.out.println("Grupos: " + grupos);

        // Filtra os grupos com tamanho do valor maior que 1, logo, os números repetidos.
        List<Integer> numerosRepetidos = grupos.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1) // Filtamos as chaves pelos valores contendo acima de 1 repetição
                .map(Map.Entry::getKey) // Pegamos apenas as chaves
                .toList(); // Coletamos para uma nova lista

        // Imprime os números repetidos.
        System.out.println("Números da lista que são iguais:" + numerosRepetidos);

//        Desafio 19 - Encontre a soma dos números divisíveis por 3 e 5:
//        Com a Stream API, encontre a soma dos números da lista que são
//        divisíveis tanto por 3 quanto por 5 e exiba o resultado no console.
        int numsDiv3e5 = numeros.stream()
                .filter(n -> n%3 == 0 && n%5 == 0)
                .reduce(0, Integer::sum);

        System.out.println("Soma dos números divisíveis por 3 e 5: " + numsDiv3e5);
    }
}
