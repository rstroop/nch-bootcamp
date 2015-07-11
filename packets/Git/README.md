# Git #

## Prerequisites ##

### Have Git Installed ###

Install the latest git in one of the following ways:

	- Download from git-scm.com (Windows)
	- Download through your package manager
		- `sudo yum install git` (RHEL and Fedora)
		- `sudo apt-get install git` (Debian and Ubuntu)
		- `brew install git` (Mac)

### Set Up Your .gitconfig ###

Your .gitconfig is your global git configuration. It lives in your home directory (`/home/<username>` on Linux, represented by `~`).

Edit/create this file by running `vim ~/.gitconfig`

You can also edit this file by using the helper git command `git config`.

To set up your user information, run the following commands in any directory (assuming `git` installed and on your PATH):

	1. `git config --global user.name "Your Name"`
	2. `git config --global user.email "your.email@example.com"

These two commands will set the "name" and "email" properties in the "[user]" section of your GLOBAL .gitconfig (the one in ~). You can check/edit this information in the aforementioned ~/.gitconfig file.

## Tutorials ##

## Links ##

### Pro Git ###

by Scott Chacon and Ben Straub -- <http://git-scm.com/book/en/v2>
Completely free book and is often better documentation for Git than the manpages.

## Labs ##

## Quiz ##