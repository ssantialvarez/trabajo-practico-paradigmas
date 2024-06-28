# trabajo-practico-paradigmas

Acomode un poco el repositorio ahi en la carpeta. Las clases estan en src/ y los csv en res/csv.

commit 1 27/06
Hasta el momento estan hechas las funciones propias del administrador, excepto la 5ta que comparte con el trader, que es el metodo para ver el estado actual. Los comentarios explican lo mejor posible lo que hice. Falta agregar la funcionalidad de mercado.csv, que detalle en los comentarios. Ademas deberia existir la posibilidad de crear un usuario. Recomiendo usar csolari, que es admin.

commit 2 27/06
El metodo ver estado actual del mercado sigue sin funcionar. Agregue los metodos para descargar mercados.csv y sus atributos en la clase Criptomoneda etc. Los archivos ahora se actualizan al cerrar el programa. aun falta la posibilidad de crear un usuario.

commit 3 28/06
agregando funcionalidades del trader. dejo enlace donde arme un diagrama simple: https://docs.google.com/drawings/d/1FPJtQxsSiezR4AprOp2ZVmCux7HCQ19hA0MauHv8yqI/edit?usp=sharing

commit 4 28/06
agregue los metodos de comprar, vender y recomendar siendo trader. agregue la clase RegistroHistorico que tiene como atributos una moneda y su cantidad. cada usuario trader va a tener su lista de RegistrosHistoricos para poder comprar y vender.
