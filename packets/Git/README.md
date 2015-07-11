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

### Presentation ###

See associated presentation. This presentation will take you through the basic concepts and commands for git.

This presentation can be accessed online at [http://slides.com/gjbiancoiv/git-init](http://slides.com/gjbiancoiv/git-init).

This same presentation is also included in this repo under `presentations/git-talk-reveal`. Just open the index.html file in a browser.

_(NB: This presentation uses Reveal.js. The presentation is divided into sections which can be traversed using left and right. The information within each section can be traversed using up and down. In other words, to progress through the presentation, use the down arrow to go forward and then the right arrow to skip or go to the next section.)_

### GitHub Usage ###

It is important to note that GitHub and git, while similar, are fundamentally different. One can use git without GitHub. However, since GitHub has historically (and for good reason) been very closely tied to the git community. It provides great tools for teams to collaborate and better organize, host, and discover code.

One of the most useful features that GitHub provides is the concept of "Pull Requests". For a GitHub repository, only people that have been given explicit "push access" are able to commit code back into the repository (even open source projects that allow anybody to download the code don't let anybody other than a trusted few push back to the repo). This whitelist does not lend itself well to projects that are intended to have hundreds or even thousands of committers. Especially when some of those committers might only need to contribute a single patch or feature to a repo.

Enter Pull Requests. They allow repository owners to maintain control over what code gets into their repo while still providing a way for people to contribute back to the project.

The basic process of creating a Pull Request is:

	1. Clone the project to your own GitHub account (some projects do not do this step or even officially allow clones; if you are not sure, ask)
	2. Create a new branch with a useful and unique name for your feature/fix (often, issue tracking numbers should be included in this name)
	3. Make the changes and commit them to your branch.
	4. Be sure to push the branch back to GitHub. (Note that, although your code is in GitHub, it is _not_ yet back into the main branch of the project)
	5. Create a Pull Request from your branch in your project to the target branch of the target repository (note that this does not have to be the same repository as yours and often is not)
		- This can be done by viewing the branch on GitHub (using the autocomplete dropdown towards the top left of the page) and selecting "Create Pull Request".

Once a Pull Request is created, it will show up in a special section where the project reviewers (trusted people given push access that can merge or decline pull requests) can view the proposed code changes, add comments, and either merge the pull request (bringing it into the project) or deny it (closing the request and decline the merge, at least for the time being).

Generally, it is good practice to "commit early, commit often". Since git keeps track of the full history of code, it is easy to revert back to a previous state. Once untracked code changes are gone, though, they are gone forever (they are untracked!). For these reasons, it is good to commit code as you progress through making the changes, even if they are not finished. As long as what you eventually merge back into master (either directly or through a Pull Request) works and is generally stable.

## Links ##

### Pro Git ###

by Scott Chacon and Ben Straub -- <http://git-scm.com/book/en/v2>
Completely free book and is often better documentation for Git than the manpages.

### Git Cheatsheet Provided by The Tower ###

<http://www.git-tower.com/blog/git-cheat-sheet/>

## Labs ##

## Quiz ##