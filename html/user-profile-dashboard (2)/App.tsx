
import React from 'react';
import { LogoIcon, ChevronDownIcon, SecurityIcon, InstagramIcon, FacebookIcon, XIcon, WhatsappIcon } from './components/Icons';

const App: React.FC = () => {
  return (
    <div className="bg-gray-50 min-h-screen flex flex-col font-sans text-gray-800">
      <Header />
      <main className="flex-grow w-full max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-12">
        <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
          <UserProfileCard />
          <ProfileDetailsCard />
        </div>
      </main>
      <Footer />
    </div>
  );
};

const Header: React.FC = () => (
  <header className="bg-white shadow-sm sticky top-0 z-10">
    <nav className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div className="flex justify-between items-center h-20">
        <div className="flex-shrink-0">
          <LogoIcon />
        </div>
        <div className="hidden md:flex items-center space-x-8">
          <a href="#" className="text-gray-600 hover:text-gray-900 flex items-center">
            Turnos <ChevronDownIcon className="ml-1 h-4 w-4" />
          </a>
          <a href="#" className="text-gray-600 hover:text-gray-900 flex items-center">
            Útil <ChevronDownIcon className="ml-1 h-4 w-4" />
          </a>
          <a href="#" className="text-gray-900 font-medium">Perfil</a>
          <a href="#" className="text-gray-600 hover:text-gray-900">Iniciar sesión</a>
        </div>
      </div>
    </nav>
  </header>
);

const UserProfileCard: React.FC = () => (
  <div className="lg:col-span-1 bg-white border border-gray-200 rounded-lg shadow-sm p-6 text-center flex flex-col items-center h-fit">
    <img
      className="w-24 h-24 rounded-full mb-4 object-cover"
      src="https://picsum.photos/seed/user123/100/100"
      alt="Profile of Castillo, Diego"
    />
    <h2 className="text-xl font-semibold text-gray-900">Castillo, Diego</h2>
    <div className="w-full mt-6 space-y-4 text-left">
      <div className="border-t border-gray-200 pt-4">
        <p className="text-sm text-gray-500">ID: <span className="text-gray-900 font-medium">74289174</span></p>
      </div>
      <div className="border-t border-gray-200 pt-4">
        <p className="text-sm text-gray-500">Role: <span className="text-gray-900 font-medium">Administrator</span></p>
      </div>
      <div className="border-t border-gray-200 pt-4">
        <a href="#" className="flex items-center text-sm text-gray-600 hover:text-gray-900 font-medium">
          <SecurityIcon className="mr-2 h-5 w-5" />
          Seguridad
        </a>
      </div>
    </div>
  </div>
);

const ProfileDetailsCard: React.FC = () => (
    <div className="lg:col-span-2 bg-white border border-gray-200 rounded-lg shadow-sm p-8">
        <h1 className="text-4xl font-bold text-gray-900">Perfil</h1>
        <div className="mt-8 grid grid-cols-1 md:grid-cols-2 gap-6">
            <InfoField label="Obra Social" value="Swiss Medical" />
        </div>
        <h2 className="text-2xl font-bold text-gray-900 mt-12">Contacto de emergencia:</h2>
        <div className="mt-8">
             <InfoField label="Teléfono" value="1541523525" fullWidth={true} />
        </div>
    </div>
);

interface InfoFieldProps {
    label: string;
    value: string;
    fullWidth?: boolean;
}

const InfoField: React.FC<InfoFieldProps> = ({ label, value, fullWidth = false }) => (
    <div className={fullWidth ? 'w-full md:w-1/2' : ''}>
        <label className="block text-sm font-medium text-gray-500 mb-2">{label}</label>
        <div className="border border-gray-300 rounded-full px-4 py-2 text-gray-800 bg-gray-50 text-sm">
            {value}
        </div>
    </div>
);


const Footer: React.FC = () => (
  <footer className="bg-[#4a8a92] text-white">
    <div className="max-w-7xl mx-auto py-12 px-4 sm:px-6 lg:px-8">
      <div className="grid grid-cols-2 md:grid-cols-4 gap-8">
        <div>
          <h3 className="text-lg font-semibold">Sucursales</h3>
          <ul className="mt-4 space-y-2 text-sm">
            <li>Av. Constituyentes 5660</li>
            <li>Chaco 3100</li>
            <li>Av. Cabildo 4900</li>
          </ul>
        </div>
        <div>
          <h3 className="text-lg font-semibold">Navegación</h3>
          <ul className="mt-4 space-y-2 text-sm">
            <li><a href="#" className="hover:underline">Home</a></li>
            <li><a href="#" className="hover:underline">Perfil</a></li>
            <li><a href="#" className="hover:underline">Iniciar sesión</a></li>
            <li><a href="#" className="hover:underline">Consultas</a></li>
            <li><a href="#" className="hover:underline">Turnos</a></li>
          </ul>
        </div>
        <div>
          <h3 className="text-lg font-semibold">Soporte</h3>
          <ul className="mt-4 space-y-2 text-sm">
            <li><a href="#" className="hover:underline">FAQ</a></li>
            <li><a href="#" className="hover:underline">Contacto</a></li>
            <li><a href="#" className="hover:underline">Tel. Emergencia</a></li>
          </ul>
        </div>
        <div>
          <h3 className="text-lg font-semibold">Redes sociales</h3>
          <div className="flex mt-4 space-x-4">
            <a href="#" className="text-white hover:text-gray-200"><InstagramIcon className="h-6 w-6" /></a>
            <a href="#" className="text-white hover:text-gray-200"><FacebookIcon className="h-6 w-6" /></a>
            <a href="#" className="text-white hover:text-gray-200"><XIcon className="h-6 w-6" /></a>
            <a href="#" className="text-white hover:text-gray-200"><WhatsappIcon className="h-6 w-6" /></a>
          </div>
        </div>
      </div>
      <div className="mt-12 pt-8 border-t border-white/20 flex flex-col sm:flex-row justify-between text-sm text-gray-200">
        <p>2025 ©</p>
        <div className="flex space-x-4 mt-4 sm:mt-0">
          <a href="#" className="hover:underline">Terminos y condiciones</a>
          <a href="#" className="hover:underline">Política y privacidad</a>
        </div>
      </div>
    </div>
  </footer>
);

export default App;