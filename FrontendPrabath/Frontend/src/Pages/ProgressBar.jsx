import React, { useState, useEffect } from 'react';

function ProgressBar() {
    const [width, setWidth] = useState(0);

    useEffect(() => {
        // Simulating API call to fetch progress from the backend
        fetchProgressFromBackend()
            .then((progress) => {
                setWidth(progress);
            })
            .catch((error) => {
                console.error('Error fetching progress:', error);
            });
    }, []);

    // Simulating API call to fetch progress from the backend
    function fetchProgressFromBackend() {
        return new Promise((resolve, reject) => {
            // Replace this with your actual API call to fetch progress from the backend
            setTimeout(() => {
                const progress = 75; // Example progress value received from the backend
                resolve(progress);
            }, 2000);
        });
    }

    return (
        <div className="progress-bar">
            <div className="progress-bar-inner" style={{ width: `${width}%`, backgroundColor: 'green' }}>
                {width}%
            </div>
        </div>
    );
}

export default ProgressBar;