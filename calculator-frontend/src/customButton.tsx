import React from 'react';

interface ButtonProps {
  label: string;       // What text shows on the button
  value: string;       // The data this button "holds"
  onPress: (val: string) => void; // The function that updates the parent state
  className?: string;  // Optional styling
}

const CustomButton: React.FC<ButtonProps> = ({ label, value, onPress, className = "" }) => {
  return (
    <button
      onClick={() => onPress(value)}
      className={`px-4 py-2 rounded bg-blue-600 text-white hover:bg-blue-700 transition ${className}`}
    >
      {label}
    </button>
  );
};

export default CustomButton;