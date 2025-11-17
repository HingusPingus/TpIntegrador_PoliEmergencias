import React, { useState } from 'react';

const App: React.FC = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (e: React.FormEvent) => {
    e.preventDefault();
    console.log('Logging in with:', { username, password });
    // In a real application, you would handle authentication here.
  };

  return (
    <main className="min-h-screen bg-gray-50 flex items-center justify-center p-4">
      <div className="flex w-full max-w-5xl bg-white shadow-xl rounded-2xl overflow-hidden">
        {/* Form Section */}
        <div className="w-full md:w-1/2 p-8 sm:p-12 flex flex-col justify-center">
          <h1 className="text-3xl md:text-4xl font-bold text-gray-800 mb-8">
            Iniciar sesión
          </h1>
          <form onSubmit={handleLogin} className="space-y-6">
            <div>
              <label
                htmlFor="username"
                className="block text-sm font-medium text-gray-600 mb-2"
              >
                Nombre de usuario
              </label>
              <input
                type="text"
                id="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                placeholder="Nombre de usuario"
                className="w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-[#5A9C9C]"
              />
            </div>
            <div>
              <label
                htmlFor="password"
                className="block text-sm font-medium text-gray-600 mb-2"
              >
                Contraseña
              </label>
              <input
                type="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Contraseña"
                className="w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-[#5A9C9C]"
              />
            </div>
            <div className="pt-2">
              <button
                type="submit"
                className="w-full bg-[#5A9C9C] text-white py-3 rounded-full font-semibold hover:bg-[#4a8383] transition-colors duration-300 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-[#5A9C9C]"
              >
                Ingresar
              </button>
            </div>
          </form>
          <p className="text-center text-sm text-gray-600 mt-8">
            ¿No tenés cuenta?{' '}
            <a href="#" className="font-semibold text-[#5A9C9C] hover:underline">
              Registrate
            </a>
          </p>
        </div>

        {/* Illustration Section */}
        <div className="hidden md:flex w-1/2">
           <img 
              src="https://images.unsplash.com/photo-1538108149393-fbbd81895907?q=80&w=1287&auto=format&fit=crop" 
              alt="Medical professionals in a hospital setting" 
              className="w-full h-full object-cover"
            />
        </div>
      </div>
    </main>
  );
};

export default App;