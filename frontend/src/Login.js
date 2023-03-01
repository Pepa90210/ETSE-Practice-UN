import {useState} from 'react';

export const useLogin = async () => {
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(null);

    const login = async (userName, password) => {
        setIsLoading(true);
        setError(null);

        // if (userName === "bennyBoy" && password === "12345") {
        //     let response = {"userName": userName, "password": password}
        //     localStorage.setItem("user", JSON.stringify(json));
        // } else {
            
        // }

        const response = await fetch("/api/volunteers", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ userName, password }),
        });
        const json = await response.json();

        if (!response.ok) {
            setIsLoading(false);
            setError(json.error);
        }
        if (response.ok) {
            // save the user to local storage
            localStorage.setItem("user", JSON.stringify(json));

            setIsLoading(false);
        }
    };

    return { login, isLoading, error };
};