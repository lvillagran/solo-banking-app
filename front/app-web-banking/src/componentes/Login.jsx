import React, { useState } from 'react';
import { motion } from 'framer-motion'; // ✅ Para animaciones suaves
import { loginUser } from '../api/auth';

const Login = ({ onLoginSuccess }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const userData = await loginUser(email, password);
      onLoginSuccess(true);
      console.log('Login exitoso.', userData);
    } catch (error) {
      alert(`Error: ${error.message}`);
      console.error('Fallo en el login:', error);
    }
  };


  
  return (
    <div className="flex items-center justify-center min-h-screen bg-gradient-to-br from-blue-600 via-blue-500 to-indigo-600">
      <motion.div
        initial={{ opacity: 0, scale: 0.9, y: 50 }}
        animate={{ opacity: 1, scale: 1, y: 0 }}
        transition={{ duration: 0.6, ease: 'easeOut' }}
        className="w-full max-w-sm p-8 space-y-6 bg-white rounded-2xl shadow-2xl"
      >
        {/* 🖼️ Logo con sombra */}
        <div className="flex justify-center mb-4">
          <img
            src="/solobank.png"
            alt="SoloBank Logo"
            className="w-30 h-30 object-contain drop-shadow-md"
          />
        </div>

        <h2 className="text-3xl font-extrabold text-center text-blue-700 tracking-tight">
          Ingreso Al Sistema
        </h2>

        <form onSubmit={handleLogin} className="space-y-5">
          <div>
            <label className="block text-sm font-semibold text-gray-700">
              Usuario:
            </label>
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              className="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:ring-blue-500 focus:border-blue-500"
              required
              placeholder='Usuario'
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-gray-700">
              Password:
            </label>
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:ring-blue-500 focus:border-blue-500"
              placeholder='Clave'
              required
            />
          </div>

          <motion.button
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.95 }}
            type="submit"
            className="w-full px-4 py-2 text-white bg-blue-600 rounded-lg shadow-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 transition-all"
          >
            Ingresar
          </motion.button>
        </form>
      </motion.div>
    </div>
  );
};

export default Login;
