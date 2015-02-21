# Workshop Programmation fonctionnelle

##Objectif
Nous allons découvrir ensemble la programmation fonctionnelle à travers une série d'exercices.
Nous allons voir les patterns de base et les contraintes associées.

##Contraintes

* Toute variable doit être `final`. De ce fait, faire une boucle est interdit car elle nécessite un compteur muable.
* L'héritage de classe est interdit, seule l'implémentation est autorisée.
* L'utilisation d'une autre classe que `Integer`, `Double`, `Boolean`, `String` et `Char` est interdite.
* L'utilisation des exceptions est interdite.


##Partie 1: List

Une des structures élémentaires de la programmation fonctionnelle est la liste simplement chaînée.
Votre liste doit être polymorphique (avec un type générique). On attend donc une signature de ce type:

	public interface List<A> {...}
	
La liste est formée d'éléments qui sont liés à leurs successeurs. Un élément d'une liste est soit:

* l'élément vide (type nommé `Nil`);
* un élément non vide (head de type `A`) + la liste des éléments restants (tail).


Donc, l'interface `List<A>` doit être implémentée par deux classes:

	class Cons<A> extends List<A>

et 

	class Nil .. extends List...


###Exercice 1
À vos claviers! Coder donc cette structure. Nous devons pouvoir créer des listes à la fin de cette étape.

###Exercice 2
Implémenter la méthode `tail` sur la liste. Vous remarquerez que l'accès se fait en temps constant!

###Exercice 3
Généraliser la méthode `tail` dans une méthode `drop (final int n)` qui retourne une liste avec `n` head en moins.

###Exercice 4
Implémenter la méthode `init` qui retourne une nouvelle liste sans son dernier élément.

###Exercice 5
Implémenter la fonction `sum` qui a la signature suivante:
	
	public static Integer sum(List<Integer> ints)

###Exercice 6
Implémenter la fonction `product` qui a la signature suivante:

	public static Integer product(List<Integer> ints)

Il est évident que ces deux méthodes se ressemblent fortement. 
Comme vous avez suivi le pattern Red => Green => Refactor, il est temps de refactorer ce code.

###Exercice 7
Généraliser `sum` et `product` par une méthode `foldRight` qui a la signature suivante:

	public <B> B foldRight(B z, BiFunction<A,B,B> f)
	
Vous remarquerez que `foldRight` n'est pas `tail recursive`. 
Cela veut dire que dans sa récursivité, la dernière ligne n'est pas un appel récursif.
Cela risque d'exploser la pile d'appels pour des listes de grande taille.

###Exercice 8
En utilisant `foldRight`, implémenter la méthode `length` sur `List`.


###Exercice 9
Écrire `foldLeft` qui est `tail-recursive`:

	public <B> B foldLeft(B z, BiFunction<B,A,B> f)	
Réfactorer `sum`, `product` et `length` avec `foldLeft`.

###Exercice 10
Implémenter une fonction qui prend en entrée une liste d'entiers et retourne une nouvelle liste avec chaque entrée incrémentée de 1.

	public static List<Integer> addOne (List<Integer> list)

###Exercice 11
Implémenter une fonction qui prend en entrée une liste et retourne une nouvelle liste avec sa représentation en `String`.

	public static List<Integer> toString (List<Integer> list)

###Exercice 12
Généraliser `addOne` et `toString` avec une méthode `map`.

	public <B> List<B> (Function<A,B> f)

###Exercice 13
Écrire une méthode `filter` qui permet de filter le contenu d'une liste.

	public List<A> filter(Predicate<A> p)

###Exercice 14
Écrire une fonction qui prend deux listes et les concatène.

	public static <A> List<A> join(List<A> left, List<A> right)

###Exercice 15
Écrire une méthode `flatMap` qui fonctionne comme `map` mais concatène les résultats.

	public <B> List<B> flatMap(Function<A, List<B>> f)

##Partie 2 : Option
Une option est un type qui contient 0 ou 1 valeur.

* l'élément vide (type nommé `None`)
* un élément non vide (type nommé `Some`)

###Exercice 1
Créer le type `Option`.

###Exercice 2
Créer une méthode `getOrElse`dont la signature est:

	A getOrElse(A default)
	
Elle retourne l'élément sous-jacent à l'option s'il est présent, la valeur par défaut fournie sinon.
 		
###Exercice 3
Créer une méthode `orElse` dont la signature est:

	Option<A> orElse(Option<A> alternative)
	
Elle retourne l'élément sous-jacent à l'option s'il est présent, l'alternative fournie sinon.
	
###Exercice 4
Créer une méthode `filter` dont la signature est:

	Option<A> filter(Predicate<A> p)
	
Son comportement est sensiblement identique à la méthode homonyme implémentée sur le type `List`à la différence qu'elle ne s'applique qu'à un seul élément.

###Exercice 5
Créer une méthode `map` dont la signature est:

	<B> Option<B> map<B>(Function<A,B> f) 
	
Son comportement est sensiblement identique à la méthode homonyme implémentée sur le type `List`à la différence qu'elle ne s'applique qu'à un seul élément.

###Exercice 6
Créer une méthode `flatMap`dont la signature est:

	<B> Option<B> flatMap<B>(Function<A, Option<B>> f)

Son comportement est sensiblement identique à la méthode homonyme implémentée sur le type `List`à la différence qu'elle ne s'applique qu'à un seul élément.
