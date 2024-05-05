
import React from 'react';

function ProgressBar({ progress }) {
  return (
    <div className="progress-bar" style={{ display: 'flex', alignItems: 'center' }}>
      <div className="progress-bar-inner" style={{
        width: `${progress}%`,
        backgroundColor: 'blue',
        height: '20px' // Added a fixed height for better visual effect
      }} />
      <span style={{ marginLeft: '10px' }}>{progress}%</span> {/* Percentage is now displayed outside the bar */}
    </div>
  );
}

export default ProgressBar;

