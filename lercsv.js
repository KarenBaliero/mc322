var DataSetComponent = (function () {
    function DataSetComponent() {
        /*private*/ this.dataSource = null;
        /*private*/ this.attributes = new Array();
        /*private*/ this.instances = new Array();
    }
    DataSetComponent.prototype.getDataSource = function () {
        return this.dataSource;
    };
    DataSetComponent.prototype.setDataSource = function (dataSource) {
        this.dataSource = dataSource;
        if (dataSource == null) {
            this.attributes = new Array();
            this.instances = new Array;
        }
        else
            this.readDS();
    };
    DataSetComponent.prototype.requestAttributes = function () {
        return this.attributes;
    };
    DataSetComponent.prototype.requestInstances = function () {
        return this.instances;
    };
    /*private*/ DataSetComponent.prototype.readDS = function () {
        var instArray = ([]);
        try {
            const fs = require('fs')
            fs.readFile('Input.csv', (err, line) => { /* Le o arquivo de nome Input.csv */
              if (err) throw err;
            })
            if (line != null) {
                var i = alert(line.charAt(i));;
                while (i != "/n") {    /* Guarda nos atributos */
                  if (i != ","){
                    var adicionar = attributes.push(i);
                  }
                  alert(str.charAt(i));
                }
                while ((line != null)) { /* aqui deveria guardar nas instancias mas ela deveria ser uma matriz */
                    {
                        var instLine = line.split(",");
                        /* add */ (instArray.push(instLine) > 0);
                    }
                }
                ;
                this.instances = instArray.slice(0);
            }
        }
        catch (erro) {
            console.error(erro.message, erro);
        }
        ;
    };
    return DataSetComponent;
}());
DataSetComponent["__class"] = "DataSetComponent";
