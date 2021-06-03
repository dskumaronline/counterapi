
Demo project for counting  the words

Java version 8
Maven version 3.8.1

Sample Request
> curl http://localhost:9000/counter-api/search -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -d’ {“searchText”:[“Duis”, “Sed”, “Donec”, “Augue”, “Pellentesque”, “123”]}’ 
-H "Content-Type: application/json" –X POST

Sample Request
> curl http://localhost:9000/counter-api/top/20 -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H ”Accept: text/csv”

```
