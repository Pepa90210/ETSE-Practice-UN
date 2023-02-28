import React from 'react'
import { useEffect, useState } from "react";
// import { useDispatch } from "react-redux";
// import { Login } from "../Login";

const HomePage = () => {

    const [user, setUser] = useState(null);

    useEffect(() => {
        const user = JSON.parse(localStorage.getItem('user'));
        setUser(user)
    }, [user?.username])

    if (!user) return (<div>You are not logged in</div>)

    return (
        <main>
            <section>
                <div className="loginContainer">
                    Welcome {user.username} You are now logged in!
                </div>
            </section>
        </main>
    );
};

export default HomePage;
