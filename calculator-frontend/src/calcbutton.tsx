import React from 'react';

interface calcButtonProps {
  label: string;
  // value can be the number or the operator
  value: string;
  onClick: (val: string) => void;
  className?: string;
  variant?: 'num' | 'op' | 'action';
}

const calcbutton: React.FC<calcButtonProps> = ({ label, value, onClick, className, variant = 'num' }) => {
  const baseStyles = "h-16 rounded-2xl text-xl font-semibold transition-all active:scale-95";
  const variants = {
    num: "bg-gray-800 text-white hover:bg-gray-700",
    op: "bg-orange-500 text-white hover:bg-orange-400",
    action: "bg-gray-400 text-black hover:bg-gray-300"
  };

  return (
    <button 
      className={`${baseStyles} ${variants[variant]} ${className}`}
      onClick={() => onClick(value)}
    >
      {label}
    </button>
  );
};

export default calcbutton;