import React, { useState } from 'react';
import { loginUser } from '../api/auth'; // Importamos la función de la API

const Login = ({ onLoginSuccess }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      // Llamamos a la función de la API y le pasamos los parámetros
      const userData = await loginUser(email, password);
      
      // Si la llamada fue exitosa (no lanzó un error), procedemos
      onLoginSuccess(true);
      console.log('Login exitoso.', userData);
    } catch (error) {
      // Si la llamada falló, el error es capturado aquí
      alert(`Error: ${error.message}`);
      console.error('Fallo en el login:', error);
    }
  };

  return (
    <div className="flex items-center justify-center min-h-screen "> 
      <div className="w-full max-w-sm p-8 space-y-6 bg-white rounded-xl shadow-lg">
        <h2 className="text-4xl font-bold text-center text-blue-600">
          Iniciar Sesión
        </h2>
        <form onSubmit={handleLogin} className="space-y-4">
          <div>
            <label className="block text-sm font-medium text-gray-700">
              Correo Electrónico
            </label>
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              className="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500"
              placeholder="tu@correo.com"
              required
            />
          </div>
          <div>
            <label className="block text-sm font-medium text-gray-700">
              Contraseña
            </label>
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500"
              placeholder="••••••••"
              required
            />
          </div>
          <button
            type="submit"
            className="w-full px-4 py-2 text-white bg-blue-600 rounded-md shadow-sm hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 transition-colors"
          >
            Entrar
          </button>
        </form>
        <p className="text-center text-sm text-gray-600">
          ¿No tienes una cuenta? {' '}
          <a href="#" className="font-medium text-blue-600 hover:text-blue-500">
            Regístrate
          </a>
        </p>
      </div>
    </div>
  );
};

export default Login;
