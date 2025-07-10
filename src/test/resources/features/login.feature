Feature: Login Feature

  @login
  Scenario Outline: Agregar Usuario Administrador
    Given inicio session en la web de la aplicacion
    When el usuario ingresa un nombre de usuario y una contraseña validos
    #And verifico el mensaje de error de login
    Then el usuario deberia ser redirigido al dashboard
    And selecciono la opcion "PIM"
    Then registro un nuevo usuario
    And ingreso un nombre de usuario"<nombreUsuario>", segundoNombre"<segundoNombre>", apellido "<apellidoUsuario>", nombre "<nombreUsuario>", contraseña "<contrasenaUsuario>"
    And completo los datos personales del usuario nacionalidad "<nacionalidad>", estado civil "<estadoCivil>", genero "<genero>", fecha de nacimiento "<fechaNacimiento>"
    Examples:
      | nombreUsuario | segundoNombre | apellidoUsuario | contrasenaUsuario | nacionalidad | estadoCivil | genero | fechaNacimiento |
      | testUser98    | Segundo88     | Apellido3383    | Contraseña320     | Peruvian     | Single      | Male   | 1990-01-01      |


