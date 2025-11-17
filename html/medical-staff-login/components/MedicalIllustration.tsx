
import React from 'react';

export const MedicalIllustration: React.FC = () => {
  return (
    <svg viewBox="0 0 450 450" xmlns="http://www.w3.org/2000/svg" className="w-full h-auto">
      {/* Background */}
      <rect width="450" height="450" fill="#EBF8FF" />

      {/* Floor */}
      <path d="M 0 450 L 150 300 L 300 300 L 450 450 Z" fill="#E0E7FF" />
      <path d="M 150 300 L 225 450" stroke="#C7D2FE" strokeWidth="1" />
      <path d="M 300 300 L 225 450" stroke="#C7D2FE" strokeWidth="1" />

      {/* Distant wall */}
      <rect x="150" y="100" width="150" height="200" fill="#D1E9F4" />
      
      {/* Distant reception */}
      <rect x="180" y="240" width="90" height="60" fill="#BEE3F8" />
      <rect x="185" y="235" width="80" height="10" fill="#A4D3ED" />
      <circle cx="225" cy="220" r="10" fill="#4A5568" />
      <rect x="223" y="220" width="4" height="20" fill="#4A5568" />


      {/* Side walls */}
      <path d="M 0 0 L 150 100 L 150 300 L 0 450 Z" fill="#C3DEED" />
      <path d="M 450 0 L 300 100 L 300 300 L 450 450 Z" fill="#C3DEED" />
      
      {/* Doors */}
      <rect x="40" y="135" width="60" height="120" fill="#BEE3F8" />
      <rect x="350" y="135" width="60" height="120" fill="#BEE3F8" />
      <circle cx="90" cy="195" r="3" fill="#A0AEC0" />
      <circle cx="360" cy="195" r="3" fill="#A0AEC0" />

      {/* Plants */}
      <rect x="120" y="260" width="20" height="40" fill="#A0AEC0" />
      <circle cx="130" cy="245" r="15" fill="#68D391" />
      <circle cx="120" cy="250" r="15" fill="#48BB78" />
      <circle cx="140" cy="250" r="15" fill="#48BB78" />
      
      <rect x="310" y="260" width="20" height="40" fill="#A0AEC0" />
      <circle cx="320" cy="245" r="15" fill="#68D391" />
      <circle cx="310"cy="250" r="15" fill="#48BB78" />
      <circle cx="330" cy="250" r="15" fill="#48BB78" />

      {/* Ceiling lights */}
      <rect x="50" y="0" width="80" height="10" fill="#FFFFFF" opacity="0.8"/>
      <rect x="185" y="20" width="80" height="10" fill="#FFFFFF" opacity="0.8"/>
      <rect x="320" y="0" width="80" height="10" fill="#FFFFFF" opacity="0.8"/>


      {/* Doctor */}
      <g transform="translate(150, 160)">
        {/* Legs */}
        <rect x="15" y="150" width="15" height="60" fill="#2D3748" />
        <rect x="35" y="150" width="15" height="60" fill="#2D3748" />
        {/* Shoes */}
        <path d="M 12 210 C 12 215, 30 215, 30 210 Z" fill="#1A202C" />
        <path d="M 32 210 C 32 215, 50 215, 50 210 Z" fill="#1A202C" />
        {/* Body */}
        <rect x="10" y="60" width="45" height="90" fill="#FFFFFF" />
        <path d="M 10 70 L 0 90 V 150 L 10 150" fill="#F7FAFC" />
        <path d="M 55 70 L 65 90 V 150 L 55 150" fill="#F7FAFC" />
        {/* Shirt and Tie */}
        <path d="M 25 60 L 32.5 75 L 40 60 Z" fill="#81E6D9" />
        <rect x="31" y="75" width="3" height="30" fill="#4A5568" />
        {/* Head */}
        <circle cx="32.5" cy="35" r="20" fill="#F6E0CE" />
        {/* Hair */}
        <path d="M 17.5 30 A 15 15 0 0 1 47.5 30 A 15 10 0 0 0 17.5 30 Z" fill="#4A5568" />
        {/* Stethoscope */}
        <path d="M 25 55 C 10 75, 10 100, 25 100" stroke="#4A5568" strokeWidth="2" fill="none" />
        <path d="M 40 55 C 55 75, 55 100, 40 100" stroke="#4A5568" strokeWidth="2" fill="none" />
        <circle cx="25" cy="100" r="4" fill="#A0AEC0" />
        {/* Clipboard */}
        <rect x="50" y="90" width="30" height="40" fill="#A0AEC0" rx="3"/>
        <rect x="55" y="95" width="20" height="3" fill="#FFFFFF" />
        <rect x="55" y="102" width="20" height="3" fill="#FFFFFF" />
        <rect x="55" y="109" width="15" height="3" fill="#FFFFFF" />
        <rect x="53" y="85" width="10" height="10" fill="#4A5568" />
      </g>
      
      {/* Nurse */}
      <g transform="translate(240, 170)">
        {/* Legs */}
        <rect x="15" y="140" width="15" height="50" fill="#81E6D9" />
        <rect x="35" y="140" width="15" height="50" fill="#81E6D9" />
        {/* Shoes */}
        <path d="M 12 190 C 12 195, 30 195, 30 190 Z" fill="#2D3748" />
        <path d="M 32 190 C 32 195, 50 195, 50 190 Z" fill="#2D3748" />
        {/* Body */}
        <path d="M 10 50 C 10 30, 55 30, 55 50 L 55 140 L 10 140 Z" fill="#81E6D9" />
        <path d="M 32.5 50 L 25 60 L 40 60 Z" fill="#4FD1C5" />
        {/* Head */}
        <circle cx="32.5" cy="25" r="20" fill="#F6E0CE" />
        {/* Hair */}
        <path d="M 15 25 A 18 18 0 0 1 50 25 V 40 H 15 Z" fill="#2D3748" />
        <path d="M 50 30 C 60 35, 60 45, 50 50 Z" fill="#2D3748" />
      </g>

      {/* Speech Bubbles */}
      <g transform="translate(140, 110)">
        <path d="M 0 20 C 0 8.95, 8.95 0, 20 0 H 40 C 51.05 0, 60 8.95, 60 20 V 20 C 60 31.05, 51.05 40, 40 40 H 20 C 8.95 40, 0 31.05, 0 20 V 20 Z" fill="#FFFFFF" stroke="#CBD5E0" strokeWidth="2"/>
        <path d="M 20 40 L 25 50 L 30 40 Z" fill="#FFFFFF" stroke="#CBD5E0" strokeWidth="2" transform="translate(0 -1)"/>
        <circle cx="20" cy="20" r="2.5" fill="#A0AEC0" />
        <circle cx="30" cy="20" r="2.5" fill="#A0AEC0" />
        <circle cx="40" cy="20" r="2.5" fill="#A0AEC0" />
      </g>

      <g transform="translate(280, 130)">
        <path d="M 0 20 C 0 8.95, 8.95 0, 20 0 H 40 C 51.05 0, 60 8.95, 60 20 V 20 C 60 31.05, 51.05 40, 40 40 H 20 C 8.95 40, 0 31.05, 0 20 V 20 Z" fill="#4299E1"/>
        <path d="M 30 40 L 35 50 L 40 40 Z" fill="#4299E1"/>
        <circle cx="20" cy="20" r="2.5" fill="#FFFFFF" />
        <circle cx="30" cy="20" r="2.5" fill="#FFFFFF" />
        <circle cx="40" cy="20" r="2.5" fill="#FFFFFF" />
        <circle cx="50" cy="20" r="2.5" fill="#FFFFFF" />
      </g>
    </svg>
  );
};
