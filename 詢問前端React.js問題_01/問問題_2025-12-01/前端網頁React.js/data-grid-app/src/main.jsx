import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import DataGridPage from './DataGridPage.jsx';

// StrictMode
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <DataGridPage />
  </StrictMode>
);
