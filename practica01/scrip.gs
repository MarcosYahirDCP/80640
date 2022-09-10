// regresa de forma textual los parámetros leidos con get
  const doGet = (e = {}) => {
    const { parameter } = e;
    const { nombre, apellido,telefono,direccion } = parameter;
    const salida = `Hola usuario: ${nombre} ${apellido}, Su numero telefonico ${telefono} , Su direccion: ${direccion}`;
    return ContentService.createTextOutput(salida);
  };

// regresa de forma textual los parámetros leidos con post
  const doPost = (e = {}) => {
    const { parameter } = e;
    const { nombre, apellido,telefono,direccion } = parameter;
    const salida = `Hola usuario: ${nombre} ${apellido} ,Su numero telefonico: ${telefono} , Su direccion:  ${direccion}`;
    return ContentService.createTextOutput(salida);
  };