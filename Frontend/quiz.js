let currentQuestionIndex = 0;
let questions = [];
let correctAnswers = 0; // Track correct answers
let totalQuestions = 0;


document.addEventListener('DOMContentLoaded', () => {
    updateQuizTitle();
    fetchQuestions();
});


function updateQuizTitle() {
    const quizType = getQuizType();
    const titleMap = {
        java: 'Java Quiz',
        python: 'Python Quiz',
        javascript: 'JavaScript Quiz',
        dotnet: '.NET Quiz'
    };
    document.getElementById('quiz-title').textContent = titleMap[quizType] || 'Quiz';
}

// Function to determine quiz type from URL
function getQuizType() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('type') || 'java'; // Default to Java if no type is specified
}


// Function to fetch questions from the API
async function fetchQuestions() {
    try {
        const response = await fetch('http://localhost:8000/quiz/questions'); // API URL
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const allQuestions = await response.json(); // Fetch all questions
        const quizType = getQuizType(); // Determine quiz type
        questions = filterQuestionsByType(allQuestions, quizType); // Filter questions based on quiz type
        totalQuestions = questions.length; // Set total questions
        document.getElementById('total-questions').textContent = totalQuestions; // Update total questions in UI
        displayQuestion();
    } catch (error) {
        console.error('Error fetching questions:', error);
        document.getElementById('question-text').textContent = "Failed to load questions. Please try again.";
    }
}



// Function to filter questions based on quiz type
function filterQuestionsByType(allQuestions, quizType) {
    switch (quizType.toLowerCase()) {
        case 'java':
            return allQuestions.slice(0, 10);
        case 'javascript':
                return allQuestions.slice(10, 20);
        case 'python':
                return allQuestions.slice(20, 30);
        case 'dotnet':
            return allQuestions.slice(30, 40);
        default:
            return [];
    }
}

// Function to display the current question
function displayQuestion() {
    if (questions.length === 0) return;

    const questionText = document.getElementById('question-text');
    const optionsContainer = document.getElementById('options-container');
    const currentQuestion = questions[currentQuestionIndex];

    questionText.textContent = currentQuestion.questionText;
    optionsContainer.innerHTML = ''; // Clear previous options

    currentQuestion.options.forEach(option => {
        const button = document.createElement('button');
        button.textContent = option;
        button.className = 'option';
        button.onclick = () => checkAnswer(option); // Check answer on click
        optionsContainer.appendChild(button);
    });

    document.getElementById('current-question').textContent = currentQuestionIndex + 1;
}

// Function to check the selected answer
function checkAnswer(selectedOption) {
    const currentQuestion = questions[currentQuestionIndex];
    if (selectedOption === currentQuestion.correctAnswer) {
        correctAnswers++; // Increment score for correct answers
    }
    nextQuestion();
}

// Function to move to the next question
function nextQuestion() {
    if (currentQuestionIndex < questions.length - 1) {
        currentQuestionIndex++;
        displayQuestion();
    } else {
        localStorage.setItem('quizScore', correctAnswers); // Save score
        localStorage.setItem('totalQuestions', totalQuestions); // Save total questions
        window.location.href = 'result.html'; // Redirect to results page
    }
}

window.onload = fetchQuestions;
