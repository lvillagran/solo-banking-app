
const API_BASE_URL = 'https://api.ejemplo.com'; // URL base de tu backend

export const loginUser = async (email, password) => {
  const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ email, password }),
  };

  try {
    const response = await fetch(`${API_BASE_URL}/login`, requestOptions);

    if (response.ok) {
      // Si el login es exitoso, devuelve los datos del usuario.
      return await response.json();
    } else {
      // Si hay un error, lanza una excepción con el mensaje del servidor.
      const errorData = await response.json();
      throw new Error(errorData.message || 'Fallo en el login.');
    }
  } catch (error) {
    // Si hay un problema de red, lanza una excepción.
    throw new Error('Hubo un error al conectar con el servidor.');
  }
};