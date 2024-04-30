import React, { useState, useEffect } from 'react';

function ProgressBar({ progress }) {
    const [width, setWidth] = useState(0);

    useEffect(() => {
        setWidth(progress);
    }, [progress]);

    return (
        <div className="progress-bar">
            <div className="progress-bar-inner" style={{ width: `${width}%`, backgroundColor: 'black' }}>
                {width}%
            </div>
        </div>
    );
}

export default ProgressBar;
