import React, { useState } from 'react';
import axios, { AxiosError } from 'axios';

interface calculationHistory {
  operationString: string;
  result: number;
}

const HistoryList: React.FC = () => {
  const [history, setHistory] = useState<calculationHistory[]>([]);
  const [loading, setLoading] = useState<boolean>(false); // Start as false
  const [error, setError] = useState<string | null>(null);
  const [showHistory, setShowHistory] = useState<boolean>(false);

  const fetchHistory = async (): Promise<void> => {
    // If we are already showing history, this button can just hide it
    if (showHistory) {
      setShowHistory(false);
      return;
    }

    try {
      setLoading(true);
      setError(null);
      
      const response = await axios.get<calculationHistory[]>(`${import.meta.env.VITE_API_URL}/math/history`, { withCredentials: false });
      
      setHistory(response.data);
      setShowHistory(true); // Show the list only after data is successfully fetched
    } catch (err) {
      const axiosError = err as AxiosError;
      setError(axiosError.message || "Failed to fetch history");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="p-4">
      {/* 1. The Trigger Button */}
      <button 
        onClick={fetchHistory}
        disabled={loading}
        className="mb-4 px-4 py-2 bg-slate-800 text-white rounded-lg hover:bg-slate-700 disabled:opacity-50 transition-colors"
      >
        {loading ? 'Loading...' : showHistory ? 'Hide History' : 'View History'}
      </button>

      {/* 2. Error Message */}
      {error && <div className="text-red-500 mb-2 font-medium">{error}</div>}

      {/* 3. Conditional Rendering of the List */}
      {showHistory && !loading && (
        <div className="bg-white rounded-xl shadow-inner p-4 border border-gray-200">
          <h3 className="font-bold text-gray-700 mb-3 border-b pb-2">Recent Calculations</h3>
          {history.length > 0 ? (
            <ol className="space-y-2">
              {history.map((item, index) => (
                <li key={index} className="text-gray-600 font-mono">
                  <span className="font-bold text-gray-900">{item.operationString}</span>
                  <span className="mx-2">=</span>
                  <span className="font-bold text-gray-900">{item.result}</span>
                </li>
              ))}
            </ol>
          ) : (
            <p className="text-gray-400 italic">No history available.</p>
          )}
        </div>
      )}
    </div>
  );
};

export default HistoryList;